package com.kafka.streams.app.serdes;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import tools.jackson.databind.json.JsonMapper;

public class SerdesFactory {

  public static <T> Serde<T> of(Class<T> clazz, JsonMapper jsonMapper) {
    JsonSerializer<T> jsonSerializer     = new JsonSerializer<>(jsonMapper);
    JsonDeserializer<T> jsonDeserializer = new JsonDeserializer<>(clazz, jsonMapper);
    return Serdes.serdeFrom(jsonSerializer, jsonDeserializer);
  }

}
