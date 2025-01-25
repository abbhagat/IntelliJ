package com.learnkafka.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learnkafka.domain.LibraryEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Slf4j
@Component
public class LibraryEventProducer {

    private final KafkaTemplate<Integer, String> kafkaTemplate;

    private final ObjectMapper objectMapper;

    private final Environment env;

    private String TOPIC_NAME;

    @Autowired
    public LibraryEventProducer(KafkaTemplate<Integer, String> kafkaTemplate, ObjectMapper objectMapper, Environment env) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
        this.env = env;
    }

    @PostConstruct
    public void postConstruct() {
        TOPIC_NAME = env.getProperty("topic.name");
    }

    public void sendLibraryEvent(LibraryEvent libraryEvent) throws JsonProcessingException {
        var key   = libraryEvent.getLibraryEventId();
        var value = objectMapper.writeValueAsString(libraryEvent);
        ListenableFuture<SendResult<Integer, String>> listenableFuture = kafkaTemplate.sendDefault(key, value);
        listenableFuture.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable ex) {
                handleFailure(key, value, ex);
            }

            @Override
            public void onSuccess(SendResult<Integer, String> result) {
                handleSuccess(key, value, result);
            }
        });
    }

    public SendResult<Integer, String> sendLibraryEventSynchronous(LibraryEvent libraryEvent) throws JsonProcessingException, TimeoutException {
        Integer key = libraryEvent.getLibraryEventId();
        String value = objectMapper.writeValueAsString(libraryEvent);
        SendResult<Integer, String> sendResult;
        try {
            sendResult = kafkaTemplate.sendDefault(key, value).get(1, TimeUnit.SECONDS);
        } catch (ExecutionException | InterruptedException e) {
            log.info("ExecutionException | InterruptedException sending the message and the exception is {} ", e.getMessage());
            throw new RuntimeException(e);
        }
        return sendResult;
    }

    public ListenableFuture<SendResult<Integer, String>> sendLibraryEventApproach2(LibraryEvent libraryEvent) throws JsonProcessingException {
        var key   = libraryEvent.getLibraryEventId();
        var value = objectMapper.writeValueAsString(libraryEvent);
        // ListenableFuture<SendResult<Integer, String>> listenableFuture = kafkaTemplate.send(TOPIC_NAME, key, value);
        ProducerRecord<Integer, String> producerRecord = buildProducerRecord(key, value, TOPIC_NAME);
        ListenableFuture<SendResult<Integer, String>> listenableFuture = kafkaTemplate.send(producerRecord);
        listenableFuture.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable ex) {
                handleFailure(key, value, ex);
            }

            @Override
            public void onSuccess(SendResult<Integer, String> result) {
                handleSuccess(key, value, result);
            }
        });
        return listenableFuture;
    }

    private ProducerRecord<Integer, String> buildProducerRecord(Integer key, String value, String topicName) {
        List<Header> headers = List.of(new RecordHeader("event-source", "scanner".getBytes()), new RecordHeader("event-type", "scanning".getBytes()));
        return new ProducerRecord<>(topicName, null, key, value, headers); // pass header as null if don't want to add extra headers
    }

    private void handleFailure(Integer key, String value, Throwable ex) {
        log.info("Error sending the message and the exception is {} ", ex.getMessage());
        try {
            throw ex;
        } catch (Throwable throwable) {
            log.error("Error in OnFailure: {}", throwable.getMessage());
        }
    }

    private void handleSuccess(Integer key, String value, SendResult<Integer, String> result) {
        log.info("Message sent successfully to the key : {} and the value is {}, partition is {} ", key, value, result.getRecordMetadata().partition());
    }

}
