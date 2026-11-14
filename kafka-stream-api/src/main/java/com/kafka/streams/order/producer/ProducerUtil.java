package com.kafka.streams.order.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Slf4j
public class ProducerUtil {

  private static final KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(producerProps());

  public static Map<String, Object> producerProps() {
    Map<String, Object> props = new HashMap<>();
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092,localhost:9093,localhost:9094");
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    return props;
  }

  public static RecordMetadata publishMessageSync(String topicName, String key, String message) {
    ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topicName, key, message);
    RecordMetadata recordMetadata = null;
    try {
      log.info("producerRecord : {}", producerRecord);
      recordMetadata = kafkaProducer.send(producerRecord).get();
    } catch (Exception e) {
      log.error("Exception in  publishMessageSync : {}  ", e.getMessage(), e);
    }
    return recordMetadata;
  }

  public static RecordMetadata publishMessageSyncWithDelay(String topicName, String key, String message , long delay){
    ProducerRecord<String,String> producerRecord = new ProducerRecord<>(topicName, 0, LocalTime.now().plusSeconds(delay).toNanoOfDay(), key, message);
    return getRecordMetadata(producerRecord);
  }

  private static RecordMetadata getRecordMetadata(ProducerRecord<String, String> producerRecord) {
    RecordMetadata recordMetadata=null;
    try {
      log.info("producerRecord : " + producerRecord);
      recordMetadata = kafkaProducer.send(producerRecord).get();
    } catch (InterruptedException e) {
      log.error("InterruptedException in  publishMessageSync : {}  ", e.getMessage(), e);
    } catch (ExecutionException e) {
      log.error("ExecutionException in  publishMessageSync : {}  ", e.getMessage(), e);
    }catch(Exception e){
      log.error("Exception in  publishMessageSync : {}  ", e.getMessage(), e);
    }
    return recordMetadata;
  }

  public static void publishMessageSync(ArrayList<ProducerRecord<String, String>> producerRecords) {
    producerRecords.forEach(ProducerUtil::getRecordMetadata);
  }
}
