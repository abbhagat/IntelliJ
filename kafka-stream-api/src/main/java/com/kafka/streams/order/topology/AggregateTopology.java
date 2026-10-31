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
    KStream<String, String> aggregateStreams = streamsBuilder.stream("words");
    aggregateStreams.print(Printed.<String, String>toSysOut().withLabel("aggregate"));
    KGroupedStream<String, String> groupedStream = aggregateStreams.groupByKey(Grouped.with(Serdes.String(), Serdes.String()));
    exploreCount(groupedStream);
    exploreReduce(groupedStream);
    return streamsBuilder.build();
  }

  private static void exploreReduce(KGroupedStream<String, String> groupedStream) {
    groupedStream.reduce((value1, value2) -> {
      log.info("value1 :{} - value2 :{}", value1, value2);
      return value1.toUpperCase() + value2.toUpperCase();
    });
  }

  private static void exploreCount(KGroupedStream<String, String> groupedStream) {
    KTable<String, Long> countByAlphabet = groupedStream.count(Named.as("count-per-alphabet"));
    countByAlphabet.toStream().print(Printed.<String, Long>toSysOut().withLabel("count-per-alphabet"));
  }
}
