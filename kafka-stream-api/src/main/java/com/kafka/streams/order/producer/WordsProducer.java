package com.kafka.streams.order.producer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import static com.kafka.streams.order.producer.ProducerUtil.publishMessageSync;

@Slf4j
public class WordsProducer {

  private static final String WORDS = "words";

  private static final Map<String, List<String>> WORDS_MAP = new HashMap<>() {
    {
      put("A", Arrays.asList("Apple", "Alligator", "Ambulance"));
      put("B", Arrays.asList("Bus", "Baby"));
    }
  };

  public static void main(String[] args) {
    WORDS_MAP.forEach((key, words) -> words.forEach(word -> log.info("Published the alphabet message : {} ", publishMessageSync(WORDS, key, word))));
  }
}
