package com.kafka.streams.app.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.streams.errors.ErrorHandlerContext;
import org.apache.kafka.streams.errors.ProductionExceptionHandler;
import java.util.Map;

@Slf4j
public class StreamsSerializationExceptionHandler implements ProductionExceptionHandler {

    @Override
    public ProductionExceptionHandler.Response handleSerializationError(
        ErrorHandlerContext context,
        ProducerRecord record,
        Exception exception,
        ProductionExceptionHandler.SerializationExceptionOrigin origin) {
        log.error(
            "Serialization exception. Origin: {}, Record: {}",
            origin,
            record,
            exception
        );
        return ProductionExceptionHandler.Response.resume();
    }

    @Override
    public void configure(Map<String, ?> configs) {
        // No custom configuration required
    }
}