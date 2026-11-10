package com.kafka.streams.order.launcher;

import com.kafka.streams.order.topology.KTableTopology;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.streams.*;
import org.apache.kafka.streams.state.KeyValueIterator;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;

import java.util.List;
import java.util.Properties;
import static com.kafka.streams.order.Util.BROKER_LIST;
import static com.kafka.streams.order.Util.LATEST;
import static com.kafka.streams.order.launcher.TopicUtil.WORDS;

@Slf4j
public class KTableStreamApp {

  private static final Properties config = new Properties();

  static {
    config.put(StreamsConfig.APPLICATION_ID_CONFIG, "kTable");
    config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, BROKER_LIST);
    config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, LATEST);
    TopicUtil.createTopics(config, List.of(WORDS));
  }

  public static void main(String[] args) {
    Topology kTableTopology = KTableTopology.buildTopology();
    KafkaStreams kafkaStreams = new KafkaStreams(kTableTopology, config);

    // Query the state store of GlobalKTable
    StoreQueryParameters<ReadOnlyKeyValueStore<String, String>> storeQueryParameters = StoreQueryParameters.fromNameAndType("word-store", QueryableStoreTypes.keyValueStore());
    ReadOnlyKeyValueStore<String, String> stateStore = kafkaStreams.store(storeQueryParameters);
    // Fetch the value for a specific key from the state store and print it
    System.out.println(stateStore.get("KEY_A"));
    // Fetch all key-value pairs from the state store and print them
    try (KeyValueIterator<String, String> iterator = stateStore.all()) {
      while (iterator.hasNext()) {
        KeyValue<String, String> entry = iterator.next();
        System.out.println(entry.key + " : " + entry.value);
      }
    }

    Runtime.getRuntime().addShutdownHook(new Thread(kafkaStreams::close));
    try {
      kafkaStreams.start();
    } catch (Exception e) {
      log.error("Exception in starting stream {}", e.getMessage());
    }
  }
}
