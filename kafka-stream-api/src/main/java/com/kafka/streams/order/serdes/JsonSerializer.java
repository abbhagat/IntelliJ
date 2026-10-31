package com.kafka.streams.order.serdes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serializer;

import java.io.IOException;

@Slf4j
public class JsonSerializer<T> implements Serializer<T> {

  private final ObjectMapper objectMapper = new ObjectMapper()
      .registerModule(new JavaTimeModule())
      .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

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
