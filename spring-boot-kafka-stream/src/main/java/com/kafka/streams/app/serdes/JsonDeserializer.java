package com.kafka.streams.app.serdes;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Deserializer;
import tools.jackson.core.JacksonException;
import tools.jackson.databind.json.JsonMapper;

@Slf4j
public class JsonDeserializer<T> implements Deserializer<T> {

  private final Class<T> destinationClass;
  private final JsonMapper jsonMapper;

  public JsonDeserializer(Class<T> destinationClass, JsonMapper jsonMapper) {
    this.destinationClass = destinationClass;
    this.jsonMapper = jsonMapper;
  }

  @Override
  public T deserialize(String topic, byte[] data) {
    if (data == null) {
      return null;
    }
    try {
      return jsonMapper.readValue(data, destinationClass);
    } catch (JacksonException e) {
      log.error("IOException in Deserializer: {} ", e.getMessage());
      throw new RuntimeException(e);
    }
  }
}
