package com.example.kafka.configuration.producer;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * SpringBoot가 기본적으로 제공해주기는 한다.
 */
@Configuration
public class KafkaTemplateConfiguration {

    @Value("${kafka.broker.url}")
    private String BROKER_URL;

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate(
            @Qualifier("producerFactory")
                    ProducerFactory<String, String> producerFactory) {
        return new KafkaTemplate<String, String>(producerFactory);
    }

    @Bean(name = "producerFactory")
    public ProducerFactory<String, String> producerFactory() {
        Map<String, Object> producerProperties = new HashMap<>();

        /**
         * Spring에서 제공해주는 기본적인 KafkaTemplate과 유사한 설정
         */
        producerProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BROKER_URL);
        producerProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        producerProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        return new DefaultKafkaProducerFactory<String, String>(producerProperties);
    }
}
