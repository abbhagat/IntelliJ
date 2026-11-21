package com.kafka.streams.order.util;

import com.kafka.streams.order.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.streams.processor.TimestampExtractor;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

@Slf4j
public class OrderTimeStampExtractor implements TimestampExtractor {

  @Override
  public long extract(ConsumerRecord<Object, Object> consumerRecord, long partitionTime) {
    Order order = (Order) consumerRecord.value();
    if (order != null && order.orderDateTime() != null) {
      LocalDateTime orderDateTime = order.orderDateTime();
      log.info("Timestamp in Extractor {}", orderDateTime);
      return convertToInstantFromIST(orderDateTime);
    }
    return partitionTime;
  }

  private long convertToInstantFromISTT(LocalDateTime orderDateTime) {
    return orderDateTime.toInstant(ZoneOffset.ofHoursMinutes(5, 30)).toEpochMilli();
  }

  private long convertToInstantFromIST(LocalDateTime orderDateTime) {
    return orderDateTime.atZone(ZoneId.of("Asia/Kolkata"))
        .toInstant()
        .toEpochMilli();
  }
}
