package com.kafka.streams.app.serdes;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;

public class SerdesFactory {

  public static <T> Serde<T> of(Class<T> clazz, ObjectMapper objectMapper) {
    JsonSerializer<T> jsonSerializer     = new JsonSerializer<>(objectMapper);
    JsonDeserializer<T> jsonDeserializer = new JsonDeserializer<>(clazz, objectMapper);
    return Serdes.serdeFrom(jsonSerializer, jsonDeserializer);
  }

}
