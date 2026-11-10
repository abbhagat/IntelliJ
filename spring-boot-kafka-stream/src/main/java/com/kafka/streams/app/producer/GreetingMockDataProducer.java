package com.kafka.streams.app.producer;

import com.kafka.streams.app.model.Greeting;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import tools.jackson.core.JacksonException;

import java.time.LocalDateTime;
import java.util.List;
import static com.kafka.streams.app.producer.ProducerUtil.publishMessageSync;
import static com.kafka.streams.app.producer.TopicUtil.GREETING_SPANISH_TOPIC;
import static com.kafka.streams.app.producer.TopicUtil.GREETING_TOPIC;
import static com.kafka.streams.app.producer.Util.jsonMapper;

@Slf4j
public class GreetingMockDataProducer {

  private static final List<Greeting> englishGreetings;
  private static final List<Greeting> spanishGreetings;

  static {
    englishGreetings = List.of(
        new Greeting("Hello, Good Morning!", LocalDateTime.now()),
        new Greeting("Hello, Good Evening!", LocalDateTime.now()),
        new Greeting("Hello, Good Night!",   LocalDateTime.now())
    );
    spanishGreetings = List.of(
        new Greeting("¡Hola buenos dias!",    LocalDateTime.now()),
        new Greeting("¡Hola buenas tardes!",  LocalDateTime.now()),
        new Greeting("¡Hola, buenas noches!", LocalDateTime.now())
    );
  }

  private static void publishEnglishGreetings() {
    englishGreetings.forEach(greeting -> {
      try {
        String greetingJSON = jsonMapper.writeValueAsString(greeting);
        RecordMetadata recordMetaData = publishMessageSync(GREETING_TOPIC, null, greetingJSON);
        log.info("Published the Greetings message : {} ", recordMetaData);
      } catch (JacksonException e) {
        throw new RuntimeException(e);
      }
    });
  }

  private static void publishSpanishGreetings() {
    spanishGreetings.forEach(greeting -> {
      try {
        String greetingJSON = jsonMapper.writeValueAsString(greeting);
        RecordMetadata recordMetaData = publishMessageSync(GREETING_SPANISH_TOPIC, null, greetingJSON);
        log.info("Published the Greetings message : {} ", recordMetaData);
      } catch (JacksonException e) {
        throw new RuntimeException(e);
      }
    });
  }

  public static void main(String[] args) {
    publishEnglishGreetings();
//    publishSpanishGreetings();
  }

}
