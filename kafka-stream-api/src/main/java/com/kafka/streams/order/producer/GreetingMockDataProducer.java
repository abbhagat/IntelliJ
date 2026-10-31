package com.kafka.streams.order.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.kafka.streams.api.domain.Greeting;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.time.LocalDateTime;
import java.util.List;

import static com.kafka.streams.api.launcher.TopicUtil.GREETING_SPANISH_TOPIC;
import static com.kafka.streams.api.launcher.TopicUtil.GREETING_TOPIC;
import static com.kafka.streams.api.producer.ProducerUtil.publishMessageSync;

@Slf4j
public class GreetingMockDataProducer {

  private static final ObjectMapper objectMapper = new ObjectMapper()
      .registerModule(new JavaTimeModule())
      .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

  public static void main(String[] args) {
    englishGreetings();
    spanishGreetings();
  }

  private static void englishGreetings() {
    List<Greeting> englishGreetings = List.of(
        new Greeting("Hello, Good Morning!", LocalDateTime.now()),
        new Greeting("Hello, Good Evening!", LocalDateTime.now()),
        new Greeting("Hello, Good Night!", LocalDateTime.now())
    );
    englishGreetings.forEach(greeting -> {
      try {
        String greetingJSON = objectMapper.writeValueAsString(greeting);
        RecordMetadata recordMetaData = publishMessageSync(GREETING_TOPIC, null, greetingJSON);
        log.info("Published the Greetings message : {} ", recordMetaData);
      } catch (JsonProcessingException e) {
        throw new RuntimeException(e);
      }
    });
  }

  private static void spanishGreetings() {
    List<Greeting> spanishGreetings = List.of(
        new Greeting("¡Hola buenos dias!", LocalDateTime.now()),
        new Greeting("¡Hola buenas tardes!", LocalDateTime.now()),
        new Greeting("¡Hola, buenas noches!", LocalDateTime.now())
    );
    spanishGreetings.forEach(greeting -> {
      try {
        String greetingJSON = objectMapper.writeValueAsString(greeting);
        RecordMetadata recordMetaData = publishMessageSync(GREETING_SPANISH_TOPIC, null, greetingJSON);
        log.info("Published the Greetings message : {} ", recordMetaData);
      } catch (JsonProcessingException e) {
        throw new RuntimeException(e);
      }
    });
  }

}
