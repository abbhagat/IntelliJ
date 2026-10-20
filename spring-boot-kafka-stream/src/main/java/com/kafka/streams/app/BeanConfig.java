package com.kafka.streams.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class BeanConfig {

  @Value("${topic.greetings.input.name:greetings}")
  private String GREETINGS;

  @Value("${topic.greetings.output.name:greetings-output}")
  private String GREETINGS_OUTPUT;

  @Bean
  public NewTopic greetingsTopic() {
    return TopicBuilder.name(GREETINGS).partitions(3).replicas(3).build();
  }

  @Bean
  public NewTopic greetingsOutputTopic() {
    return TopicBuilder.name(GREETINGS_OUTPUT).partitions(3).replicas(3).build();
  }

  @Bean
  public ObjectMapper objectMapper() {
    return new ObjectMapper()
        .registerModule(new JavaTimeModule())
        .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
  }

}
