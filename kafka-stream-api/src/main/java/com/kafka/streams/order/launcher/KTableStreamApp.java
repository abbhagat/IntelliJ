package com.kafka.streams.order.launcher;

import com.kafka.streams.api.topology.KTableTopology;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;

import java.util.List;
import java.util.Properties;

import static com.kafka.streams.api.topology.KTableTopology.WORDS;

@Slf4j
public class KTableStreamApp {

  private static final Properties config = new Properties();

  static {
    config.put(StreamsConfig.APPLICATION_ID_CONFIG, "ktable");
    config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092,localhost:9093,localhost:9094");
    config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
    TopicUtil.createTopics(config, List.of(WORDS));
  }

  public static void main(String[] args) {
    Topology kTableTopology = KTableTopology.buildTopology();
    KafkaStreams kafkaStreams = new KafkaStreams(kTableTopology, config);
    Runtime.getRuntime().addShutdownHook(new Thread(kafkaStreams::close));
    try {
      kafkaStreams.start();
    } catch (Exception e) {
      log.error("Exception in starting stream {}", e.getMessage());
    }
  }
}
