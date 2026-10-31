package com.kafka.streams.order.serdes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.streams.order.domain.Greeting;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

@Slf4j
public class GreetingDeserializer implements Deserializer<Greeting> {

  private final ObjectMapper objectMapper;

  public GreetingDeserializer(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  @Override
  public Greeting deserialize(String topic, byte[] data) {
    try {
      return objectMapper.readValue(data, Greeting.class);
    } catch (IOException e) {
      log.error("JSON Processing Exception : {} ", e.getMessage());
      throw new RuntimeException(e);
    }
  }
}
