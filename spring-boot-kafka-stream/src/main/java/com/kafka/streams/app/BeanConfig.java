package com.kafka.streams.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.kafka.streams.app.exception.StreamsProcessorCustomErrorHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.streams.StreamsConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.kafka.autoconfigure.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.config.KafkaStreamsConfiguration;
import org.springframework.kafka.config.StreamsBuilderFactoryBeanConfigurer;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.listener.ConsumerRecordRecoverer;
import org.springframework.kafka.streams.RecoveringDeserializationExceptionHandler;
import java.util.Map;

@Slf4j
@Configuration
public class BeanConfig {

  @Value("${topic.greetings.input.name:greetings}")
  private String GREETINGS;

  @Value("${topic.greetings.output.name:greetings-output}")
  private String GREETINGS_OUTPUT;

  private final KafkaProperties kafkaProperties;

  public BeanConfig(KafkaProperties kafkaProperties) {
    this.kafkaProperties = kafkaProperties;
  }

  @Bean
  public NewTopic greetingsTopic() {
    return TopicBuilder.name(GREETINGS).partitions(3).replicas(3).build();
  }

  @Bean
  public NewTopic greetingsOutputTopic() {
    return TopicBuilder.name(GREETINGS_OUTPUT).partitions(3).replicas(3).build();
  }

  @Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
  public KafkaStreamsConfiguration kafkaStreamsConfiguration() {
    Map<String, Object> kafkaStreamProperties = kafkaProperties.buildStreamsProperties();
    kafkaStreamProperties.put(StreamsConfig.DESERIALIZATION_EXCEPTION_HANDLER_CLASS_CONFIG, RecoveringDeserializationExceptionHandler.class);
    kafkaStreamProperties.put(RecoveringDeserializationExceptionHandler.RECOVERER, recoverer());
    return new KafkaStreamsConfiguration(kafkaStreamProperties);
  }

  @Bean
  public StreamsBuilderFactoryBeanConfigurer streamsBuilderFactoryBeanConfigurer() {
    return factoryBeanCofigurer -> {
      factoryBeanCofigurer.setStreamsUncaughtExceptionHandler(new StreamsProcessorCustomErrorHandler());
    };
  }

  private ConsumerRecordRecoverer recoverer() {
    return ((consumerRecord, e) -> log.error(
        "Deserialization error. Topic={}, partition={}, offset={}",
        consumerRecord.topic(),
        consumerRecord.partition(),
        consumerRecord.offset(),
        e
    ));
  }

  @Bean
  public ObjectMapper objectMapper() {
    return new ObjectMapper()
        .registerModule(new JavaTimeModule())
        .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
  }

}
