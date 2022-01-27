package com.boot.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class KafkaListenerOrConsumer {

    Logger LOG = LoggerFactory.getLogger(KafkaListenerOrConsumer.class);

    @KafkaListener(topics = "topic-1")
    void listener(String data) {
        LOG.info(data);
    }

    @KafkaListener(topics = "topic-1, topic-2", groupId = "topic-group-2")
    void commonListenerForMultipleTopics(String message) {
        LOG.info("MultipleTopicListener - {}", message);
    }

    @KafkaListener(topics = "topic-1")
    @SendTo("topic-2")
    void listenAndReply(String message) {
        LOG.info("MultipleTopicListener - {}", message);
    }
}
