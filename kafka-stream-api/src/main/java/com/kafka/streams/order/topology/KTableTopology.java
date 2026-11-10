package com.kafka.streams.order.topology;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StoreQueryParameters;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.*;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.springframework.stereotype.Component;

import static com.kafka.streams.order.launcher.TopicUtil.WORDS;

@Slf4j
@Component
public class KTableTopology {

  public static Topology buildTopology() {

    StreamsBuilder streamsBuilder = new StreamsBuilder();

    Consumed<String, String> consumed = Consumed.with(Serdes.String(), Serdes.String());

    KTable<String, String> wordsTable = streamsBuilder.table(WORDS, consumed, Materialized.as("word-store"));

    wordsTable.filter((key, value) -> value.length() > 2)
              .toStream()
              .peek((key, value) -> log.info("key: {} value: {}", key, value))
              .print(Printed.<String, String>toSysOut().withLabel("words-KTable"));
    wordsTable.toStream()
              .mapValues((readOnlyKey, value) -> value.toUpperCase())
              .to("words-uppercase", Produced.with(Serdes.String(), Serdes.String()));

    GlobalKTable<String, String> wordsGlobalTable = streamsBuilder.globalTable(WORDS, consumed, Materialized.as("word-global-store"));

    return streamsBuilder.build();
  }
}
