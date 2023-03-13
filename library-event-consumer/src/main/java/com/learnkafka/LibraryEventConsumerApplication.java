package com.learnkafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LibraryEventConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryEventConsumerApplication.class, args);
    }
}
