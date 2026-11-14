package com.kafka.streams.order.topology;

import com.kafka.streams.order.model.Order;
import com.kafka.streams.order.model.TotalRevenue;
import com.kafka.streams.order.serdes.SerdesFactory;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.*;
import org.apache.kafka.streams.state.KeyValueStore;

public class OrderTopologyUtil {

  private OrderTopologyUtil() {
    // private constructor to prevent instantiation
  }

  private static final Initializer<TotalRevenue> TOTAL_REVENUE_INITIALIZER = TotalRevenue::new;
  private static final Aggregator<String, Order, TotalRevenue> REVENUE_AGGREGATOR = (key, value, totalRevenue) -> totalRevenue.calculateTotalRevenue(key, value);

  public static void aggregateOrderByCount(KStream<String, Order> orderStream, String stateStore) {
    KTable<String, Long> orderKTable = orderStream.map((key, value) -> KeyValue.pair(value.locationId(), value))
                                                  .groupByKey(Grouped.with(Serdes.String(), SerdesFactory.getSerdes(Order.class)))
                                                  .count(Named.as(stateStore), Materialized.as(stateStore));
    orderKTable.toStream().print(Printed.<String, Long>toSysOut().withLabel(stateStore));
  }

  public static void aggregateOrderByRevenue(KStream<String, Order> orderStream, String stateStore) {
    Materialized<String, TotalRevenue, KeyValueStore<Bytes, byte[]>> MATERIALIZED  = Materialized.<String, TotalRevenue, KeyValueStore<Bytes, byte[]>>as(stateStore).withKeySerde(Serdes.String()).withValueSerde(SerdesFactory.getSerdes(TotalRevenue.class));
    KTable<String, TotalRevenue> orderKTable = orderStream.map((key, value) -> KeyValue.pair(value.locationId(), value))
                                                          .groupByKey(Grouped.with(Serdes.String(), SerdesFactory.getSerdes(Order.class)))
                                                          .aggregate(TOTAL_REVENUE_INITIALIZER, REVENUE_AGGREGATOR, MATERIALIZED);
    orderKTable.toStream().print(Printed.<String, TotalRevenue>toSysOut().withLabel(stateStore));
  }
}
