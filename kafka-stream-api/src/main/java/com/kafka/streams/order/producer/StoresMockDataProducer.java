package com.kafka.streams.order.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import static com.kafka.streams.order.Util.getStoresList;
import static com.kafka.streams.order.Util.objectMapper;
import static com.kafka.streams.order.launcher.TopicUtil.STORES;
import static com.kafka.streams.order.producer.ProducerUtil.publishMessageSync;

@Slf4j
public class StoresMockDataProducer {

  public static void main(String[] args) {
    var stores = getStoresList();
    stores
        .forEach(store -> {
          try {
            String storeJSON = objectMapper.writeValueAsString(store);
            RecordMetadata recordMetaData = publishMessageSync(STORES, store.locationId(), storeJSON);
            log.info("Published the store message : {} ", recordMetaData);
          } catch (JsonProcessingException e) {
            log.error("JsonProcessingException : {} ", e.getMessage(), e);
            throw new RuntimeException(e);
          } catch (Exception e) {
            log.error("Exception : {} ", e.getMessage(), e);
            throw new RuntimeException(e);
          }
        });
  }
}
