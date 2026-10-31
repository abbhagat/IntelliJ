package com.kafka.streams.order.launcher;

import com.kafka.streams.api.topology.AggregateTopology;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;

import java.util.Properties;

@Slf4j
public class AggregateStreamsApp {

  private static final Properties config = new Properties();
  private static final String BROKER_LIST = "localhost:9092,localhost:9093,localhost:9094";
  private static final String LATEST = "latest";

  static {
    config.put(StreamsConfig.APPLICATION_ID_CONFIG, "aggregate-topology");
    config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, BROKER_LIST);
    config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, LATEST);
    config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.StringSerde.class);
    config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.StringSerde.class);
    config.put(StreamsConfig.COMMIT_INTERVAL_MS_CONFIG, 5000);

    TopicUtil.createTopic(config, TopicUtil.WORDS);
  }

  public static void main(String[] args) {
    Topology aggregateTopology = AggregateTopology.buildTopology();
    KafkaStreams kafkaStreams = new KafkaStreams(aggregateTopology, config);
    Runtime.getRuntime().addShutdownHook(new Thread(kafkaStreams::close));
    try {
      kafkaStreams.start();
    } catch (Exception e) {
      log.error("Exception in starting stream {}", e.getMessage());
    }
  }
}
