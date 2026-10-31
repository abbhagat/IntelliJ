package com.kafka.streams.order.serdes;

import com.kafka.streams.api.domain.Greeting;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;

public class SerdesFactory {

  public static Serde<Greeting> greetingSerdes() {
    return new GreetingSerdes();
  }

  public static Serde<Greeting> greetingSerdesUsingGenerics() {
    JsonSerializer<Greeting> jsonSerializer = new JsonSerializer<>();
    JsonDeserializer<Greeting> jsonDeserializer = new JsonDeserializer<>(Greeting.class);
    return Serdes.serdeFrom(jsonSerializer, jsonDeserializer);
  }

}
