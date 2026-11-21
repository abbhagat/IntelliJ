package com.kafka.streams.order.topology;

import com.kafka.streams.order.model.*;
import com.kafka.streams.order.serdes.SerdesFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.*;
import org.apache.kafka.streams.state.KeyValueStore;

import java.time.Duration;

@Slf4j
public class OrderTopologyUtil {

  private static final Initializer<TotalRevenue> TOTAL_REVENUE_INITIALIZER;
  private static final Aggregator<String, Order, TotalRevenue> TOTAL_REVENUE_AGGREGATOR;
  private static final ValueJoiner<TotalRevenue, Store, TotalRevenueWithAddress> TOTAL_REVENUE_WITH_ADDRESS_VALUE_JOINER;
  private static final ValueJoiner<Long, Store, TotalCountWithAddress> TOTAL_COUNT_WITH_ADDRESS_VALUE_JOINER;

  static {
    TOTAL_REVENUE_INITIALIZER = TotalRevenue::new;
    TOTAL_REVENUE_AGGREGATOR = (key, value, totalRevenue) -> totalRevenue.calculateTotalRevenue(key, value);
    TOTAL_REVENUE_WITH_ADDRESS_VALUE_JOINER = TotalRevenueWithAddress::new;
    TOTAL_COUNT_WITH_ADDRESS_VALUE_JOINER = TotalCountWithAddress::new;
  }

  private OrderTopologyUtil() {
    // private constructor to prevent instantiation
  }

  public static void aggregateOrderByCount(KStream<String, Order> orderStream, String stateStore) {
    KTable<String, Long> orderKTable = orderStream.map((key, value) -> KeyValue.pair(value.locationId(), value))
        .groupByKey(Grouped.with(Serdes.String(), SerdesFactory.getSerdes(Order.class)))
        .count(Named.as(stateStore), Materialized.as(stateStore));
    orderKTable.toStream().print(Printed.<String, Long>toSysOut().withLabel(stateStore));
  }

  public static void aggregateOrdersCountByTimeWindows(KStream<String, Order> orderStream, String stateStore) {
    Duration windowSize = Duration.ofSeconds(15);
    TimeWindows timeWindows = TimeWindows.ofSizeWithNoGrace(windowSize);
    KGroupedStream<String, Order> kGroupedStream = orderStream.map((key, value) -> KeyValue.pair(value.locationId(), value))
                                                              .groupByKey(Grouped.with(Serdes.String(), SerdesFactory.getSerdes(Order.class)));
    TimeWindowedKStream<String, Order> timeWindowedKStream = kGroupedStream.windowedBy(timeWindows);
    KTable<Windowed<String>, Long> ordersCountPerStore = timeWindowedKStream.count(Named.as(stateStore), Materialized.as(stateStore))
                                                                    .suppress(Suppressed.untilWindowCloses(Suppressed.BufferConfig.unbounded().shutDownWhenFull()));
    ordersCountPerStore
        .toStream()
        .peek((key, value) -> {
          log.info("State Store Name : {}, key : {} , value : {} ", stateStore, key, value);
        })
        .print(Printed.<Windowed<String>, Long>toSysOut().withLabel(stateStore));

  }

  public static void aggregateOrderByRevenue(KStream<String, Order> orderStream, String stateStore, KTable<String, Store> storeKTable) {
    Materialized<String, TotalRevenue, KeyValueStore<Bytes, byte[]>> MATERIALIZED = Materialized.<String, TotalRevenue, KeyValueStore<Bytes, byte[]>>as(stateStore).withKeySerde(Serdes.String()).withValueSerde(SerdesFactory.getSerdes(TotalRevenue.class));
    KTable<String, TotalRevenue> orderKTable = orderStream.map((key, value) -> KeyValue.pair(value.locationId(), value))
        .groupByKey(Grouped.with(Serdes.String(), SerdesFactory.getSerdes(Order.class)))
        .aggregate(TOTAL_REVENUE_INITIALIZER, TOTAL_REVENUE_AGGREGATOR, MATERIALIZED);
    orderKTable.toStream().print(Printed.<String, TotalRevenue>toSysOut().withLabel(stateStore));

    // KTable to KTable Join
    KTable<String, TotalRevenueWithAddress> totalRevenueWithAddressKTable = orderKTable.join(storeKTable, TOTAL_REVENUE_WITH_ADDRESS_VALUE_JOINER);
    totalRevenueWithAddressKTable.toStream().print(Printed.<String, TotalRevenueWithAddress>toSysOut().withLabel(stateStore + "-with-address"));
  }
}
