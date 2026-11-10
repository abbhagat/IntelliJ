package com.kafka.streams.app.config;

import com.kafka.streams.app.exception.StreamsProcessorCustomErrorHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.StreamsConfig;
import org.springframework.boot.kafka.autoconfigure.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.config.KafkaStreamsConfiguration;
import org.springframework.kafka.config.StreamsBuilderFactoryBeanConfigurer;
import org.springframework.kafka.listener.ConsumerRecordRecoverer;
import org.springframework.kafka.streams.RecoveringDeserializationExceptionHandler;
import tools.jackson.databind.SerializationFeature;
import tools.jackson.databind.json.JsonMapper;
import java.util.Map;

@Slf4j
@Configuration
public class BeanConfig {

  private final KafkaProperties kafkaProperties;

  public BeanConfig(KafkaProperties kafkaProperties) {
    this.kafkaProperties = kafkaProperties;
  }

  @Bean
  public JsonMapper jsonMapper() {
    return JsonMapper.builder()
        .findAndAddModules()
        .configure(SerializationFeature.INDENT_OUTPUT, false)
        .build();
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
    return factoryBeanCofigurer -> factoryBeanCofigurer.setStreamsUncaughtExceptionHandler(new StreamsProcessorCustomErrorHandler());
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
}
