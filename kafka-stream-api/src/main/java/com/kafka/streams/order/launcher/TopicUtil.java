package com.kafka.streams.order.launcher;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;

import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

@Slf4j
public class TopicUtil {

  public static final String GREETING_TOPIC = "greetings";
  public static final String GREETING_UPPERCASE_TOPIC = "greetings_uppercase";
  public static final String GREETING_SPANISH_TOPIC = "greetings_spanish";
  public static final String WORDS = "words";
  private static final int numPartitions = 3;
  private static final short replicationFactor = 3;

  public static void createTopics(Properties brokerConfig, List<String> topicsNameList) {
    try (AdminClient admin = AdminClient.create(brokerConfig)) {
      List<NewTopic> newTopics = topicsNameList
          .stream()
          .map(topicName -> new NewTopic(topicName, numPartitions, replicationFactor))
          .collect(Collectors.toList());
      CreateTopicsResult createTopicResult = admin.createTopics(newTopics);
      try {
        createTopicResult.all().get();
        log.info("Topics created successfully");
      } catch (Exception e) {
        log.error("Exception creating topics : {} ", e.getMessage(), e);
      }
    }
  }

  public static void createTopic(Properties brokerConfig, String topic) {
    try (AdminClient admin = AdminClient.create(brokerConfig)) {
      CreateTopicsResult createTopicResult = admin.createTopics(List.of(new NewTopic(topic, numPartitions, replicationFactor)));
      try {
        createTopicResult.all().get();
        log.info("Topics created successfully");
      } catch (Exception e) {
        log.error("Exception creating topics : {} ", e.getMessage(), e);
      }
    }
  }
}
