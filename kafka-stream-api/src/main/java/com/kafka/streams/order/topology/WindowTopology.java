package com.kafka.streams.order.topology;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.*;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Slf4j
public class WindowTopology {

  public static final String WINDOW_WORDS = "windows-words";

  public static Topology build() {
    StreamsBuilder streamsBuilder = new StreamsBuilder();
    KStream<String, String> wordsStream = streamsBuilder.stream(WINDOW_WORDS, Consumed.with(Serdes.String(), Serdes.String()));
    tumblingWindow(wordsStream);
    hoppingWindow(wordsStream);
    slidingWindow(wordsStream);
    return streamsBuilder.build();
  }

  private static void tumblingWindow(KStream<String, String> wordsStream) {
    Duration windowSize = Duration.ofSeconds(15);
    TimeWindows timeWindows = TimeWindows.ofSizeWithNoGrace(windowSize);
    KTable<Windowed<String>, Long> windowedKTable = wordsStream
        .groupByKey()
        .windowedBy(timeWindows)
        .count()
        .suppress(Suppressed.untilWindowCloses(Suppressed.BufferConfig.unbounded().shutDownWhenFull()));
    windowedKTable
        .toStream()
        .peek((key, value) -> log.info("Windowed Key: {}, Count: {}", key, value))
        .foreach(WindowTopology::printLocalDateTimes);
  }

  private static void hoppingWindow(KStream<String, String> wordsStream) {
    Duration windowSize    = Duration.ofSeconds(5);
    Duration advanceBySize = Duration.ofSeconds(3);
    TimeWindows hoppingWindow = TimeWindows.ofSizeWithNoGrace(windowSize).advanceBy(advanceBySize);
    KTable<Windowed<String>, Long> windowedKTable = wordsStream
        .groupByKey()
        .windowedBy(hoppingWindow)
        .count()
        .suppress(Suppressed.untilWindowCloses(Suppressed.BufferConfig.unbounded().shutDownWhenFull()));
    windowedKTable
        .toStream()
        .peek((key, value) -> log.info("Hopping Windowed Key: {}, Count: {}", key, value))
        .foreach(WindowTopology::printLocalDateTimes);
  }

  private static void slidingWindow(KStream<String, String> wordsStream) {
    Duration windowSize = Duration.ofSeconds(5);
//    SlidingWindows slidingWindow = SlidingWindows.ofTimeDifferenceAndGrace(windowSize, Duration.ZERO);
    SlidingWindows slidingWindow = SlidingWindows.ofTimeDifferenceWithNoGrace(windowSize);
    KTable<Windowed<String>, Long> windowedKTable = wordsStream
        .groupByKey()
        .windowedBy(slidingWindow)
        .count()
        .suppress(Suppressed.untilWindowCloses(Suppressed.BufferConfig.unbounded().shutDownWhenFull()));
    windowedKTable
        .toStream()
        .peek((key, value) -> log.info("Sliding Windowed Key: {}, Count: {}", key, value))
        .foreach(WindowTopology::printLocalDateTimes);
  }

  private static void printLocalDateTimes(Windowed<String> key, Long value) {
    Instant startTime = key.window().startTime();
    Instant endTime = key.window().endTime();
    LocalDateTime startLDT = LocalDateTime.ofInstant(startTime, ZoneId.of(ZoneId.SHORT_IDS.get("CST")));
    LocalDateTime endLDT = LocalDateTime.ofInstant(endTime, ZoneId.of(ZoneId.SHORT_IDS.get("CST")));
    log.info("startLDT : {} , endLDT : {}, Count : {}", startLDT, endLDT, value);
  }
}
