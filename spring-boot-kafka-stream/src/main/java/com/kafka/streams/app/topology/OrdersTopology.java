package com.kafka.streams.app.topology;

import com.kafka.streams.app.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.serializer.JacksonJsonSerde;
import org.springframework.stereotype.Component;
import tools.jackson.databind.json.JsonMapper;
import static com.kafka.streams.app.model.OrderType.GENERAL;
import static com.kafka.streams.app.model.OrderType.RESTAURANT;
import static com.kafka.streams.app.producer.TopicUtil.ORDERS;

@Slf4j
@Component
public class OrdersTopology {

  private static final Predicate<String, Order> generalPredicate    = (key, order) -> GENERAL.equals(order.orderType());
  private static final Predicate<String, Order> restaurantPredicate = (key, order) -> RESTAURANT.equals(order.orderType());

  private final JsonMapper jsonMapper;

  public OrdersTopology(JsonMapper jsonMapper) {
    this.jsonMapper = jsonMapper;
  }

  @Autowired
  public Topology buildTopology(StreamsBuilder streamsBuilder) {
    KStream<String, Order> ordersKStream = streamsBuilder.stream(ORDERS, Consumed.with(Serdes.String(), new JacksonJsonSerde<>(Order.class, jsonMapper)));
    ordersKStream.print(Printed.<String, Order>toSysOut().withLabel("Orders Stream"));
    ordersKStream
        .split(Named.as("order-stream"))
        .branch(generalPredicate, Branched.withConsumer(orderStream -> {
          orderStream.print(Printed.<String, Order>toSysOut().withLabel("General Orders Stream"));
          orderStream.to("general-orders", Produced.with(Serdes.String(), new JacksonJsonSerde<>(Order.class, jsonMapper)));
        }))
        .branch(restaurantPredicate, Branched.withConsumer(orderStream -> {
          orderStream.print(Printed.<String, Order>toSysOut().withLabel("Restaurant Orders Stream"));
          orderStream.to("restaurant-orders", Produced.with(Serdes.String(), new JacksonJsonSerde<>(Order.class, jsonMapper)));
        }));
    return streamsBuilder.build();
  }
}
