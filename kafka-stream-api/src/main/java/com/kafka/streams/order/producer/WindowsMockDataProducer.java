package com.kafka.streams.order.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;

@Slf4j
public class WindowsMockDataProducer {

  public static void main(String[] args) throws InterruptedException {
    bulkMockDataProducer();
  }

  private static void bulkMockDataProducer() throws InterruptedException {
    String topic = "windows-words";
    String[] keys = {"A", "B", "C", "D", "E", "F", "G"};
    String[] words = {"Apple", "Alligator", "Ambulance", "Bus", "Baby", "Cat", "Dog", "Elephant", "Frog", "Giraffe"};
    for (int i = 1; i <= 100; i++) {
      RecordMetadata recordMetadata = ProducerUtil.publishMessageSync(topic, keys[i % keys.length], words[i % words.length]);
      log.info("Published message to topic: {}, partition: {}, offset: {}", recordMetadata.topic(), recordMetadata.partition(), recordMetadata.offset());
      Thread.sleep(500);
    }
  }
}
