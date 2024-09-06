package com.learnkafka.config;

import com.learnkafka.jpa.FailureRecordRepository;
import com.learnkafka.service.FailureRecordService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.TopicPartition;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.RecoverableDataAccessException;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.ConsumerRecordRecoverer;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.kafka.support.ExponentialBackOffWithMaxRetries;
import org.springframework.util.backoff.ExponentialBackOff;
import org.springframework.util.backoff.FixedBackOff;

import java.util.List;

@Slf4j
@EnableKafka
@Configuration
public class LibraryEventsConsumerConfig {

    @Autowired
    private KafkaProperties properties;

    @Autowired
    private KafkaTemplate<Integer, String> kafkaTemplate;

    @Autowired
    private FailureRecordService failureRecordService;

    @Value("${topics.retry}")
    private String retryTopic;

    @Value("${topics.dlt}")
    private String deadLetterTopic;

    public static final String RETRY = "RETRY";
    public static final String DEAD = "DEAD";
    public static final String SUCCESS = "SUCCESS";

    public DeadLetterPublishingRecoverer publishingRecoverer() {
        return new DeadLetterPublishingRecoverer(kafkaTemplate, (consumerRecord, e) ->
                e.getCause() instanceof RecoverableDataAccessException ? new TopicPartition(retryTopic, consumerRecord.partition())
                                                                       : new TopicPartition(deadLetterTopic, consumerRecord.partition())
        );
    }

    ConsumerRecordRecoverer consumerRecordRecoverer = (consumerRecord, e) -> {
        var record = (ConsumerRecord<Integer, String>) consumerRecord;
        if (e.getCause() instanceof RecoverableDataAccessException) {
            // recovery logic
            log.info("Inside Recovery");
            failureRecordService.saveFailureRecord(record, e, RETRY);
        } else {
           // non recovery logic
            log.info("Inside Non Recovery");
            failureRecordService.saveFailureRecord(record, e, RETRY);
        }
    };

    public DefaultErrorHandler errorHandler() {
        var exceptionToIgnoreList = List.of(IllegalArgumentException.class);
        var exceptionToRetryList = List.of(RecoverableDataAccessException.class);
        var fixedBackOff = new FixedBackOff(1000L, 2);
        var expBackOff = new ExponentialBackOffWithMaxRetries(2);
        expBackOff.setInitialInterval(1_000L);
        expBackOff.setMultiplier(2.0);
        expBackOff.setMaxInterval(2_000L);
        var errorHandler = new DefaultErrorHandler(
                // publishingRecoverer(),
                //fixedBackOff
                consumerRecordRecoverer,
                expBackOff
        );
        errorHandler.addNotRetryableExceptions();
        exceptionToIgnoreList.forEach(errorHandler::addNotRetryableExceptions);
        exceptionToRetryList.forEach(errorHandler::addRetryableExceptions);
        errorHandler.setRetryListeners((consumerRecord, ex, deliveryAttempt) -> {
            log.info("Failed Record in Retry Listener, Exception : {} , deliveryAttempt {}", ex.getMessage(), deliveryAttempt);
        });
        return errorHandler;
    }

    @Bean
    @ConditionalOnMissingBean(name = {"kafkaListenerContainerFactory"})
    public ConcurrentKafkaListenerContainerFactory<?, ?> kafkaListenerContainerFactory(ConcurrentKafkaListenerContainerFactoryConfigurer configurer, ObjectProvider<ConsumerFactory<Object, Object>> kafkaConsumerFactory) {
        ConcurrentKafkaListenerContainerFactory<Object, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
        configurer.configure(factory, kafkaConsumerFactory.getIfAvailable(() -> new DefaultKafkaConsumerFactory<>(this.properties.buildConsumerProperties())));
        // factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL);
        factory.setConcurrency(3);
        factory.setCommonErrorHandler(errorHandler());
        return factory;
    }
}
