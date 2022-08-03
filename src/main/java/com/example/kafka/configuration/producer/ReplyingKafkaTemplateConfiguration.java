package com.example.kafka.configuration.producer;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * 말 그대로 Consumer에게서 Response를 받는다.
 * sendAndReceive 메소드를 사용한다.
 */
@Configuration
public class ReplyingKafkaTemplateConfiguration {

    @Value("${kafka.broker.url}")
    private String BROKER_URL;

    @Bean
    public ReplyingKafkaTemplate<String, String, String> replyingKafkaTemplate(
            @Qualifier("replyingKafkaProducerFactory")
                    ProducerFactory<String, String> producerFactory,
            ConcurrentMessageListenerContainer<String, String> containerFactory
    ) {
        return new ReplyingKafkaTemplate<String, String, String>(producerFactory, containerFactory);
    }

    @Bean
    public ConcurrentMessageListenerContainer<String, String> repliesContainer(ConcurrentKafkaListenerContainerFactory<String, String> containerFactory) {
        ConcurrentMessageListenerContainer<String, String> container = containerFactory.createContainer("topic");
        /**
         * 기타 설정들을 추가 할 수 있다.
         */
        container.setTopicCheckTimeout(40);
        container.getContainerProperties().setGroupId("id");
        return container;
    }


    @Bean(name = "replyingKafkaProducerFactory")
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
