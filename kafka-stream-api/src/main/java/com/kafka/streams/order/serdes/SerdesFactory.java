package com.kafka.streams.order.serdes;

import com.kafka.streams.order.domain.Greeting;
import com.kafka.streams.order.domain.Order;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;

public class SerdesFactory {

  public static GreetingSerdes greetingSerdes() {
    return new GreetingSerdes();
  }

  public static Serde<Greeting> greetingSerdesUsingGenerics() {
    JsonSerializer<Greeting> jsonSerializer = new JsonSerializer<>();
    JsonDeserializer<Greeting> jsonDeserializer = new JsonDeserializer<>(Greeting.class);
    return Serdes.serdeFrom(jsonSerializer, jsonDeserializer);
  }

  public static Serde<Order> orderSerdes() {
    JsonSerializer<Order> jsonSerializer = new JsonSerializer<>();
    JsonDeserializer<Order> jsonDeserializer = new JsonDeserializer<>(Order.class);
    return Serdes.serdeFrom(jsonSerializer, jsonDeserializer);
  }

}
