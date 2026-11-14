package com.kafka.streams.order.topology;

import com.kafka.streams.order.model.Order;
import com.kafka.streams.order.serdes.SerdesFactory;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.*;

public class OrderTopologyUtil {

  private OrderTopologyUtil() {
    // private constructor to prevent instantiation
  }

  public static void aggregateOrderByCount(KStream<String, Order> orderStream, String stateStoreName) {
    KTable<String, Long> orderKTable = orderStream.map((key, value) -> KeyValue.pair(value.locationId(), value))
                                                  .groupByKey(Grouped.with(Serdes.String(), SerdesFactory.getSerdes(Order.class)))
                                                  .count(Named.as(stateStoreName), Materialized.as(stateStoreName));
    orderKTable.toStream().print(Printed.<String, Long>toSysOut().withLabel(stateStoreName));
  }
}
