package com.kafka.streams.order.topology;

import com.kafka.streams.order.model.Order;
import com.kafka.streams.order.model.Store;
import com.kafka.streams.order.model.TotalRevenue;
import com.kafka.streams.order.model.TotalRevenueWithAddress;
import com.kafka.streams.order.serdes.SerdesFactory;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.*;
import org.apache.kafka.streams.state.KeyValueStore;

public class OrderTopologyUtil {

  private static final Initializer<TotalRevenue> TOTAL_REVENUE_INITIALIZER;
  private static final Aggregator<String, Order, TotalRevenue> TOTAL_REVENUE_AGGREGATOR;
  private static final ValueJoiner<TotalRevenue, Store, TotalRevenueWithAddress> TOTAL_REVENUE_WITH_ADDRESS_VALUE_JOINER;

  static {
    TOTAL_REVENUE_INITIALIZER = TotalRevenue::new;
    TOTAL_REVENUE_AGGREGATOR = (key, value, totalRevenue) -> totalRevenue.calculateTotalRevenue(key, value);
    TOTAL_REVENUE_WITH_ADDRESS_VALUE_JOINER = TotalRevenueWithAddress::new;

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
