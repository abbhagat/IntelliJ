package com.kafka.streams.order.topology;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.*;

@Slf4j
public class AggregateTopology {

  private static final StreamsBuilder streamsBuilder = new StreamsBuilder();

  public static Topology buildTopology() {
    KStream<String, String> aggregateStreams = streamsBuilder.stream("words");  // Default Serdes is StringSerde in effect
    aggregateStreams.print(Printed.<String, String>toSysOut().withLabel("aggregate"));
    KGroupedStream<String, String> groupedStream = aggregateStreams.groupByKey(Grouped.with(Serdes.String(), Serdes.String()));
    exploreCount(groupedStream);
    exploreReduce(groupedStream);
    return streamsBuilder.build();
  }

  private static void exploreCount(KGroupedStream<String, String> groupedStream) {
    KTable<String, Long> countByAlphabet = groupedStream.count(Named.as("count-per-alphabet"), Materialized.as("count-per-alphabet-state-store"));
    countByAlphabet
        .toStream()
        .print(Printed.<String, Long>toSysOut().withLabel("count-per-alphabet"));
  }

  private static void exploreReduce(KGroupedStream<String, String> groupedStream) {
    Reducer<String> reducer = (value1, value2) -> String.join("_", value1.toUpperCase(), value2.toUpperCase());
    KTable<String, String> groupByKeyVal = groupedStream.reduce(reducer, Materialized.as("reduce-per-alphabet-state-store"));
    groupByKeyVal
      .toStream()
      .print(Printed.<String, String>toSysOut().withLabel("reduce-per-alphabet"));
  }
}
