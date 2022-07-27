package com.example.kafka.configuration;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.ByteArraySerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.core.RoutingKafkaTemplate;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 전송하는 토픽별로 다르게 Routing 할 수 있다.
 */
public class RoutingKafkaTemplateConfiguration {

    @Value("${kafka.broker.url}")
    private String BROKER_URL;

    @Bean
    public RoutingKafkaTemplate routingKafkaTemplate() {
        return new RoutingKafkaTemplate(factories());
    }

    /**
     * <String,String> 타입이 아닌 이유는
     * 어떤 것으로 직렬화/역직렬화 될지 모르기 때문이다.
     */
    private Map<Pattern, ProducerFactory<Object, Object>> factories() {
        Map<Pattern, ProducerFactory<Object, Object>> factories = new LinkedHashMap<>();
        factories.put(Pattern.compile("byte-array"), byteArrayProducerFactory());
        factories.put(Pattern.compile(".*"), defaultProducerFactory());
        return factories;
    }

    private ProducerFactory<Object, Object> byteArrayProducerFactory() {
        Map<String, Object> producerProperties = new HashMap<>();
        producerProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BROKER_URL);
        producerProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class);
        producerProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class);

        return new DefaultKafkaProducerFactory<>(producerProperties);

    }

    private ProducerFactory<Object, Object> defaultProducerFactory() {
        Map<String, Object> producerProperties = new HashMap<>();
        producerProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BROKER_URL);
        producerProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        producerProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        return new DefaultKafkaProducerFactory<>(producerProperties);
    }
}
