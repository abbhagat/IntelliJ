package com.kafka.streams.order.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.ArrayList;
import java.util.Map;

import static com.kafka.streams.order.producer.ProducerUtil.publishMessageSync;
import static com.kafka.streams.order.producer.ProducerUtil.publishMessageSyncWithDelay;
import static com.kafka.streams.order.topology.JoinsOperatorsTopology.ALPHABETS_ABBREVIATIONS;
import static java.time.Instant.now;

@Slf4j
public class JoinsMockDataProducer {

  public static void main(String[] args) throws InterruptedException {
    var alphabetMap = Map.of(
        "A", "A is the 1st letter in English Alphabet",
        "B", "B is the 2nd letter in English Alphabet"
    );
    //publishMessages(alphabetMap, ALPHABETS);
    //JoinWindows
    //-4 & 4 will trigger the join -6 -5 & 5, 6 won't trigger the join
    //publishMessagesWithDelay(alphabetMap, ALPHABETS, 4);
    var alphabetAbbreviationMap = Map.of("A", "Apple", "B", "Bus", "C", "Cat");
    publishMessages(alphabetAbbreviationMap, ALPHABETS_ABBREVIATIONS);
    alphabetAbbreviationMap = Map.of("A", "Airplane", "B", "Baby");
    // publishMessages(alphabetAbbreviationMap, ALPHABETS_ABBREVIATIONS);
  }

  private static void publishMessagesToSimulateGrace(Map<String, String> alphabetMap, String topicName, int delaySeconds) throws InterruptedException {
    var producerRecords = new ArrayList<ProducerRecord<String, String>>();
    alphabetMap.forEach((key, value) -> producerRecords.add(new ProducerRecord<>(topicName, 0, now().toEpochMilli(), key, value)));
    Thread.sleep(delaySeconds * 1000L);
    publishMessageSync(producerRecords);
  }

  private static void publishMessagesWithDelay(Map<String, String> alphabetMap, String topic, int delaySeconds) {
    alphabetMap.forEach((key, value) -> {
      var recordMetaData = publishMessageSyncWithDelay(topic, key, value, delaySeconds);
      log.info("Published the alphabet message : {} ", recordMetaData);
    });
  }

  private static void publishMessages(Map<String, String> alphabetMap, String topic) {
    alphabetMap
        .forEach((key, value) -> {
          var recordMetaData = publishMessageSync(topic, key, value);
          log.info("Published the alphabet message : {} ", recordMetaData);
        });
  }
}
