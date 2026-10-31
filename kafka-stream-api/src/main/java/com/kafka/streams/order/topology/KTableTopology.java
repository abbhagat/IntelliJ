package com.kafka.streams.order.topology;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.*;

@Slf4j
public class KTableTopology {

  public static final String WORDS = "words";

  public static Topology buildTopology() {
    StreamsBuilder streamsBuilder = new StreamsBuilder();
    Consumed<String, String> consumed = Consumed.with(Serdes.String(), Serdes.String());

    KTable<String, String> wordsTable = streamsBuilder.table(WORDS, consumed, Materialized.as("word-store"));

    wordsTable.filter((key, value) -> value.length() > 2)
        .toStream()
        .peek((key, value) -> log.info("key: {} value: {}", key, value))
        .print(Printed.<String, String>toSysOut().withLabel("words-KTable"));

    GlobalKTable<String, String> wordsGlobalTable = streamsBuilder.globalTable(WORDS, consumed, Materialized.as("word-global-store"));

    return streamsBuilder.build();
  }
}
