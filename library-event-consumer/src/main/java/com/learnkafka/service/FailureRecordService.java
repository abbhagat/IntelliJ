package com.learnkafka.service;

import com.learnkafka.entity.FailureRecord;
import com.learnkafka.jpa.FailureRecordRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FailureRecordService {

    private FailureRecordRepository failureRecordRepository;

    public FailureRecordService(FailureRecordRepository repository) {
        this.failureRecordRepository = repository;
    }


    public void saveFailureRecord(ConsumerRecord<Integer,String> consumerRecord, Exception e, String status) {
        var failureRecord = FailureRecord.builder()
                .id(null)
                .topic(consumerRecord.topic())
                .key(consumerRecord.key())
                .errorRecord(consumerRecord.value())
                .partition(consumerRecord.partition())
                .offset_value(consumerRecord.offset())
                .exception(e.getCause().getMessage())
                .status(status)
                .build();
        failureRecordRepository.save(failureRecord);
    }
}
