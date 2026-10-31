package com.kafka.streams.order.producer;

import lombok.extern.slf4j.Slf4j;
import static com.kafka.streams.order.producer.ProducerUtil.publishMessageSync;

@Slf4j
public class WordsProducer {

  private static final String WORDS = "words";
  private static final String KEY_A = "A";
  private static final String KEY_B = "B";
  private static final String word1 = "Apple";
  private static final String word2 = "Alligator";
  private static final String word3 = "Ambulance";
  private static final String word4 = "Bus";
  private static final String word5 = "Baby";

  public static void main(String[] args) {

    log.info("Published the alphabet message : {} ", publishMessageSync(WORDS, KEY_A, word1));
    log.info("Published the alphabet message : {} ", publishMessageSync(WORDS, KEY_A, word2));
    log.info("Published the alphabet message : {} ", publishMessageSync(WORDS, KEY_A, word3));

    log.info("Published the alphabet message : {} ", publishMessageSync(WORDS, KEY_B, word4));
    log.info("Published the alphabet message : {} ", publishMessageSync(WORDS, KEY_B, word5));
  }

}
