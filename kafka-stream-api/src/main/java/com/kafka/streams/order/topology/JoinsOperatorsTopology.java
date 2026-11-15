package com.kafka.streams.order.topology;

import com.kafka.streams.order.model.Alphabet;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.*;
import java.time.Duration;

@Slf4j
public class JoinsOperatorsTopology {

  public static String ALPHABETS = "alphabets"; // A -> First letter in the english alphabet
  public static String ALPHABETS_ABBREVIATIONS = "alphabets_abbreviations"; // A ->  Apple

  private static final ValueJoiner<String, String, Alphabet> valueJoiner;
  private static final JoinWindows joinWindows;
  private static final StreamJoined<String, String, String> streamJoined;
  private static final StreamJoined<String, String, String> leftStreamJoined;
  private static final StreamJoined<String, String, String> outerStreamJoined;

  static {
    valueJoiner       = Alphabet::new;
    joinWindows       = JoinWindows.ofTimeDifferenceWithNoGrace(Duration.ofSeconds(5));
    streamJoined      = StreamJoined.with(Serdes.String(), Serdes.String(), Serdes.String()).withName("innerJoin-KStream-With-KStream");
    leftStreamJoined  = StreamJoined.with(Serdes.String(), Serdes.String(), Serdes.String()).withName("leftJoin-KStream-With-KStream");
    outerStreamJoined = StreamJoined.with(Serdes.String(), Serdes.String(), Serdes.String()).withName("outerJoin-KStream-With-KStream");
  }

  public static Topology build() {
    StreamsBuilder streamsBuilder = new StreamsBuilder();
    joinKStreamWithKTable(streamsBuilder);
    joinKStreamWithGlobalKTable(streamsBuilder);
    joinKTableWithKTable(streamsBuilder);
    joinKStreamWithKStream(streamsBuilder);
    return streamsBuilder.build();
  }

  private static void joinKStreamWithKTable(StreamsBuilder streamsBuilder) {

    KStream<String, String> kStream = streamsBuilder.stream(ALPHABETS_ABBREVIATIONS, Consumed.with(Serdes.String(), Serdes.String()));
    kStream.print(Printed.<String, String>toSysOut().withLabel("alphabets_abbreviations-kStream"));
    KTable<String, String> kTable = streamsBuilder.table(ALPHABETS, Consumed.with(Serdes.String(), Serdes.String()), Materialized.as("alphabets-KTable"));
    kTable.toStream().print(Printed.<String, String>toSysOut().withLabel("alphabets-KTable"));

    ValueJoiner<String, String, Alphabet> valueJoiner = Alphabet::new;

    KStream<String, Alphabet> joinedStream = kStream.join(kTable, valueJoiner);
    joinedStream.print(Printed.<String, Alphabet>toSysOut().withLabel("join-KStream-With-KTable"));
  }

  private static void joinKStreamWithGlobalKTable(StreamsBuilder streamsBuilder) {

    KStream<String, String> kStream = streamsBuilder.stream(ALPHABETS_ABBREVIATIONS, Consumed.with(Serdes.String(), Serdes.String()));
    kStream.print(Printed.<String, String>toSysOut().withLabel("alphabets_abbreviations-kStream"));
    GlobalKTable<String, String> globalKTable = streamsBuilder.globalTable(ALPHABETS, Consumed.with(Serdes.String(), Serdes.String()), Materialized.as("alphabets-global-KTable"));

    ValueJoiner<String, String, Alphabet> valueJoiner = Alphabet::new;
    KeyValueMapper<String, String, String> keyValueMapper = (leftKey, rightKey) -> leftKey;

    KStream<String, Alphabet> joinedStream = kStream.join(globalKTable, keyValueMapper, valueJoiner);

    joinedStream.print(Printed.<String, Alphabet>toSysOut().withLabel("join-KStream-With-GlobalKTable"));
  }

  private static void joinKTableWithKTable(StreamsBuilder streamsBuilder) {

    KTable<String, String> alphaAbbrevKTable = streamsBuilder.table(ALPHABETS_ABBREVIATIONS, Consumed.with(Serdes.String(), Serdes.String()), Materialized.as("alphabets_abbreviations-KTable"));
    alphaAbbrevKTable.toStream().print(Printed.<String, String>toSysOut().withLabel("alphabets_abbreviations-KTable"));

    KTable<String, String> alphaKTable = streamsBuilder.table(ALPHABETS, Consumed.with(Serdes.String(), Serdes.String()), Materialized.as("alphabets-KTable"));
    alphaKTable.toStream().print(Printed.<String, String>toSysOut().withLabel("alphabets-KTable"));

    ValueJoiner<String, String, Alphabet> valueJoiner = Alphabet::new;

    KTable<String, Alphabet> joinedStream = alphaAbbrevKTable.join(alphaKTable, valueJoiner);
    joinedStream.toStream().print(Printed.<String, Alphabet>toSysOut().withLabel("join-KStream-With-KTable"));
  }

  private static void joinKStreamWithKStream(StreamsBuilder streamsBuilder) {

    KStream<String, String> alphaAbbrevKStream = streamsBuilder.stream(ALPHABETS_ABBREVIATIONS, Consumed.with(Serdes.String(), Serdes.String()));
    alphaAbbrevKStream.print(Printed.<String, String>toSysOut().withLabel("alphabets_abbreviations-kStream"));

    KStream<String, String> alphaKStream = streamsBuilder.stream(ALPHABETS, Consumed.with(Serdes.String(), Serdes.String()));
    alphaKStream.print(Printed.<String, String>toSysOut().withLabel("alphabets-KStream"));

    KStream<String, Alphabet> joinedStream      = alphaAbbrevKStream.join(alphaKStream, valueJoiner, joinWindows, streamJoined);
    joinedStream.print(Printed.<String, Alphabet>toSysOut().withLabel("join-KStream-With-KStream"));

    KStream<String, Alphabet> leftJoinedStream  = alphaAbbrevKStream.leftJoin(alphaKStream, valueJoiner, joinWindows, leftStreamJoined);
    leftJoinedStream.print(Printed.<String, Alphabet>toSysOut().withLabel("leftJoin-KStream-With-KStream"));

    KStream<String, Alphabet> outerJoinedStream = alphaAbbrevKStream.outerJoin(alphaKStream, valueJoiner, joinWindows, outerStreamJoined);
    outerJoinedStream.print(Printed.<String, Alphabet>toSysOut().withLabel("outerJoin-KStream-With-KStream"));
  }
}
