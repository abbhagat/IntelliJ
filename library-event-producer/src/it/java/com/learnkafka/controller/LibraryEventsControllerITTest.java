package com.learnkafka.controller;

import com.learnkafka.domain.Book;
import com.learnkafka.domain.LibraryEvent;
import com.learnkafka.domain.LibraryEventType;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.test.context.TestPropertySource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EmbeddedKafka(topics = {"library-events"}, partitions = 3)
@TestPropertySource(properties = {"spring.kafka.producer.bootstrap-servers=${spring.embedded.kafka.brokers}" ,
                                  "spring.kafka.admin.properties.bootstrap-servers=${spring.embedded.kafka.brokers}"
                                 }
                   )
public class LibraryEventsControllerITTest {

    private final TestRestTemplate restTemplate;

    private final EmbeddedKafkaBroker embeddedKafkaBroker;

    private Consumer<Integer, String> consumer;

    @Autowired
    public LibraryEventsControllerITTest(TestRestTemplate restTemplate, EmbeddedKafkaBroker embeddedKafkaBroker) {
        this.restTemplate = restTemplate;
        this.embeddedKafkaBroker = embeddedKafkaBroker;
    }

    @BeforeEach
    public void setUp() {
        Map<String, Object> configMap = new HashMap<>(KafkaTestUtils.consumerProps("group1", "true", embeddedKafkaBroker));
        DefaultKafkaConsumerFactory defaultKafkaConsumerFactory = new DefaultKafkaConsumerFactory<>(configMap, new IntegerDeserializer(), new StringDeserializer());
        consumer = defaultKafkaConsumerFactory.createConsumer();
        // consumer.subscribe(List.of("library-events"));
        embeddedKafkaBroker.consumeFromAllEmbeddedTopics(consumer);
    }

    @AfterEach
    public void tearDown() {
        consumer.close();
    }

    @Test
    @Timeout(5)
    public void postLibraryEvents() {
        Book book = Book.builder()
                .bookId(123)
                .bookAuthor("Abhinaw")
                .bookName("Kafka")
                .build();
        LibraryEvent libraryEvent = LibraryEvent.builder()
                .libraryEventId(null)
                .libraryEventType(LibraryEventType.NEW)
                .book(book).build();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<LibraryEvent> request = new HttpEntity<>(libraryEvent, headers);
        ResponseEntity<LibraryEvent> responseEntity = restTemplate.exchange("/v1/libraryEvent", HttpMethod.POST, request, LibraryEvent.class);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        ConsumerRecord<Integer, String> consumerRecord = KafkaTestUtils.getSingleRecord(consumer, "library-events");
        final String expected = "{\"libraryEventId\":null,\"libraryEventType\":\"NEW\",\"book\":{\"bookId\":123,\"bookName\":\"Kafka\",\"bookAuthor\":\"Abhinaw\"}}";
        String value = consumerRecord.value();
        assertEquals(expected, value);
    }

    @Test
    @Timeout(5)
    public void putLibraryEvents() {
        Book book = Book.builder()
                .bookId(123)
                .bookAuthor("Abhinaw")
                .bookName("Kafka")
                .build();
        LibraryEvent libraryEvent = LibraryEvent.builder()
                .libraryEventId(123)
                .libraryEventType(LibraryEventType.UPDATE)
                .book(book).build();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<LibraryEvent> request = new HttpEntity<>(libraryEvent, headers);
        ResponseEntity<LibraryEvent> responseEntity = restTemplate.exchange("/v1/libraryEvent", HttpMethod.PUT, request, LibraryEvent.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        ConsumerRecord<Integer, String> consumerRecord = KafkaTestUtils.getSingleRecord(consumer, "library-events");
        String expected = "{\"libraryEventId\":123,\"libraryEventType\":\"UPDATE\",\"book\":{\"bookId\":123,\"bookName\":\"Kafka\",\"bookAuthor\":\"Abhinaw\"}}";
        String value = consumerRecord.value();
        assertEquals(expected, value);
    }
}
