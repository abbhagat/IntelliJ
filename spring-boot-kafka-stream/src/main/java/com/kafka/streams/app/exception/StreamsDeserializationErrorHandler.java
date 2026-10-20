package com.kafka.streams.app.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.streams.errors.DeserializationExceptionHandler;
import org.apache.kafka.streams.errors.ErrorHandlerContext;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class StreamsDeserializationErrorHandler implements DeserializationExceptionHandler {

  private final AtomicInteger errorCounter = new AtomicInteger(0);

  @Override
  public Response handleError(ErrorHandlerContext context, ConsumerRecord<byte[], byte[]> record, Exception exception) {
    int count = errorCounter.incrementAndGet();
    log.error(
        "Deserialization error. Topic={}, partition={}, offset={}, count={}",
        record.topic(),
        record.partition(),
        record.offset(),
        count,
        exception
    );
    if (count <= 10) {
      return Response.resume();
    }
    return Response.fail();
  }

  @Override
  public void configure(Map<String, ?> configs) {
    // No additional configuration required.
  }
}
