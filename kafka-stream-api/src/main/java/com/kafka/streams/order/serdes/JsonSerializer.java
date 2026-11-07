package com.kafka.streams.order.serdes;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serializer;
import java.io.IOException;
import static com.kafka.streams.order.Util.objectMapper;

@Slf4j
public class JsonSerializer<T> implements Serializer<T> {

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
