package com.learnkafka.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FailureRecord {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer key;
    private Integer partition;
    private String topic;
    private String errorRecord;
    private String exception;
    private String status;
    private long offset_value;

}
