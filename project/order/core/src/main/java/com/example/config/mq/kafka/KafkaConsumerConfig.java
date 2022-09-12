package com.example.config.mq.kafka;

import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.kafka.listener.ConsumerProperties;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.ContainerProperties.AckMode;

@Configuration
public class KafkaConsumerConfig {
  @Value("${kafka.broker.url}")
  private String BROKER_URL;

  @Bean
  @Primary
  public ConcurrentKafkaListenerContainerFactory<String, String>
      concurrentKafkaListenerContainerFactory(ConsumerFactory<String, String> consumerFactory) {

    ConcurrentKafkaListenerContainerFactory<String, String> containerFactory =
        new ConcurrentKafkaListenerContainerFactory<>();

    containerFactory.setConsumerFactory(consumerFactory);
    containerFactory.getContainerProperties().setAckMode(AckMode.MANUAL_IMMEDIATE);

    return containerFactory;
  }

  @Bean
  @Primary
  public ConsumerFactory<String, String> consumerFactory() {
    Map<String, Object> properties = new LinkedHashMap<>();

    properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BROKER_URL);
    properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
    properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);

    return new DefaultKafkaConsumerFactory(properties);
  }
}
