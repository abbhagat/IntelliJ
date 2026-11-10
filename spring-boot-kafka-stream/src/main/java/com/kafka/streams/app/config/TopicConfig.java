package com.kafka.streams.app.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfig {

  @Value("${topic.greetings.input.name:greetings}")
  private String GREETINGS;

  @Value("${topic.greetings.output.name:greetings-output}")
  private String GREETINGS_OUTPUT;

  @Value("${topic.orders.name:orders}")
  private String ORDERS;

  @Value("${topic.stores.name:stores}")
  private String STORES;

  @Bean
  public NewTopic greetingsTopic() {
    return TopicBuilder.name(GREETINGS)
        .partitions(3)
        .replicas(3)
        .build();
  }

  @Bean
  public NewTopic greetingsOutputTopic() {
    return TopicBuilder.name(GREETINGS_OUTPUT)
        .partitions(3)
        .replicas(3)
        .build();
  }

  @Bean
  public NewTopic ordersTopic() {
    return TopicBuilder.name(ORDERS)
        .partitions(3)
        .replicas(3)
        .build();
  }

  @Bean
  public NewTopic storesTopic() {
    return TopicBuilder.name(STORES)
        .partitions(3)
        .replicas(3)
        .build();
  }
}
