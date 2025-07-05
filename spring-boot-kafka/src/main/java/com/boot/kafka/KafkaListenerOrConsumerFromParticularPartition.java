package com.boot.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

public class KafkaListenerOrConsumerFromParticularPartition {

    Logger LOG = LoggerFactory.getLogger(KafkaListenerOrConsumerFromParticularPartition.class);

    @KafkaListener(groupId = "topic-group", topicPartitions = @TopicPartition(topic = "topic-1", partitionOffsets = {@PartitionOffset(partition = "0", initialOffset = "0")}))
    void listenToPartitionWithOffset(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION) int partition, @Header(KafkaHeaders.OFFSET) int offset) {
        LOG.info("Received message [{}] from partition-{} with offset-{}", message, partition, offset);
    }
}
