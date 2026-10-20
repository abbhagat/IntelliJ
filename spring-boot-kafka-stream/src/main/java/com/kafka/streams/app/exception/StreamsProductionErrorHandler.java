package com.kafka.streams.app.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.streams.errors.ErrorHandlerContext;
import org.apache.kafka.streams.errors.ProductionExceptionHandler;
import java.util.Map;

@Slf4j
public class StreamsProductionErrorHandler implements ProductionExceptionHandler {

  @Override
  public void configure(Map<String, ?> map) {

  }

  @Override
  public Response handleError(ErrorHandlerContext context, ProducerRecord<byte[], byte[]> record, Exception exception) {
    log.error(
        "Production error. Topic={}, partition={}, offset={}",
        record.topic(),
        record.partition(),
        record.key(),
        exception
    );
    return ProductionExceptionHandler.Response.resume();
  }
}