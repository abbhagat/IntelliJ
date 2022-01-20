package com.tinyurl.kafka;

import com.tinyurl.service.URLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaListenerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private URLService service;

    public void sendMessage(String msg) {
        kafkaTemplate.send("url-shortening", msg);
    }

    @KafkaListener(topics = "url-shortening", groupId = "group-id")
    public void listen(String message) {
        System.out.println("Received Message in group - group-id: " + message);
    }
}
