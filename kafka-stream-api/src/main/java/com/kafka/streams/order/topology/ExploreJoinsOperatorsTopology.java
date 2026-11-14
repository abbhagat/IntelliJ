package com.kafka.streams.order.topology;

import com.kafka.streams.order.model.Alphabet;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.*;

@Slf4j
public class ExploreJoinsOperatorsTopology {


  public static String ALPHABETS = "alphabets"; // A -> First letter in the english alphabet
  public static String ALPHABETS_ABBREVIATIONS = "alphabets_abbreviations"; // A ->  Apple

  public static Topology build() {
    StreamsBuilder streamsBuilder = new StreamsBuilder();
    joinKStreamWithKTable(streamsBuilder);
    return streamsBuilder.build();
  }

  private static void joinKStreamWithKTable(StreamsBuilder streamsBuilder) {
    KStream<String, String> kStream = streamsBuilder.stream(ALPHABETS_ABBREVIATIONS, Consumed.with(Serdes.String(), Serdes.String()));
    kStream.print(Printed.<String, String>toSysOut().withLabel("alphabets_abbreviations-kStream"));
    KTable<String, String> kTable = streamsBuilder.table(ALPHABETS, Consumed.with(Serdes.String(), Serdes.String()), Materialized.as("alphabets-KTable"));
    kTable.toStream().print(Printed.<String, String>toSysOut().withLabel("alphabets-KTable"));

    ValueJoiner<String, String, Alphabet> valueJoiner = Alphabet::new;

    KStream<String, Alphabet> joinedStream = kStream.join(kTable, valueJoiner);
    joinedStream.print(Printed.<String, Alphabet>toSysOut().withLabel("joinedStream"));
  }

}
