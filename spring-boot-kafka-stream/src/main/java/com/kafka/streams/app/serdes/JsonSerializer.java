package com.kafka.streams.app.serdes;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serializer;
import java.io.IOException;

@Slf4j
public class JsonSerializer<T> implements Serializer<T> {

  private final ObjectMapper objectMapper;

  public JsonSerializer(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  @Override
  public byte[] serialize(String topic, T t) {
    try {
      return objectMapper.writeValueAsBytes(t);
    } catch (IOException e) {
      log.error("IOException in Serializer: {} ", e.getMessage());
      throw new RuntimeException(e);
    } catch (Exception e) {
      log.error("Exception in Serializer : {} ", e.getMessage());
      throw new RuntimeException(e);
    }
  }
}
