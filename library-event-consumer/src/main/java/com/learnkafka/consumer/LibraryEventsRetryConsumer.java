package com.learnkafka.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.learnkafka.service.LibraryEventsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LibraryEventsRetryConsumer {

    @Autowired
    private LibraryEventsService libraryEventsService;


    @KafkaListener(topics = {"${topics.retry}"}, groupId = "retry-listener-group" , autoStartup = "${retryListener.startup:true}")
    public void onMessage(ConsumerRecord<Integer, String> consumerRecord) throws JsonProcessingException {
        log.info("ConsumerRecord in Retry Consumer: {} ", consumerRecord);
        libraryEventsService.processLibraryEvent(consumerRecord);
    }
}
