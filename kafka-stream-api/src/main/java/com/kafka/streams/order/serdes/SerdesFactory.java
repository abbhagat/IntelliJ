package com.kafka.streams.order.serdes;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;

public class SerdesFactory {

  public static <T> Serde<T> getSerdes(Class<T> clazz) {
    JsonSerializer<T> jsonSerializer     = new JsonSerializer<>();
    JsonDeserializer<T> jsonDeserializer = new JsonDeserializer<>(clazz);
    return Serdes.serdeFrom(jsonSerializer, jsonDeserializer);
  }

}
