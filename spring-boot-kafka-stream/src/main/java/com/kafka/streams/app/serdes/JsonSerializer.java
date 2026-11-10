package com.kafka.streams.app.serdes;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serializer;
import tools.jackson.core.JacksonException;
import tools.jackson.databind.json.JsonMapper;

@Slf4j
public class JsonSerializer<T> implements Serializer<T> {

  private final JsonMapper jsonMapper;

  public JsonSerializer(JsonMapper jsonMapper) {
    this.jsonMapper = jsonMapper;
  }

  @Override
  public byte[] serialize(String topic, T t) {
    try {
      return jsonMapper.writeValueAsBytes(t);
    } catch (JacksonException e) {
      log.error("IOException in Serializer: {} ", e.getMessage());
      throw new RuntimeException(e);
    }
  }
}
