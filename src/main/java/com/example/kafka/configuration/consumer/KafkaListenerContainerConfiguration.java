package com.example.kafka.configuration.consumer;

import com.example.kafka.consumer.listener.DefaultMessageListener;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class KafkaListenerContainerConfiguration {

    @Value("${kafka.broker.url}")
    private String BROKER_URL;


    /**
     * Container는 Listener의 Property 이다.
     * --> Listener를 소유한다. (꼭 Listener를 갖고있어야 한다.)
     * --> Listener는 구현해주어야 한다.
     *
     * KafkaMessageListenerContainer를 가지고
     * pause(), resume()을 통해서 Listen 여부를 결정 할 수 있다.
     * 장애가 났을 떄, 서버를 내리는 것이 아닌 특정 ListenerContainer를 내림으로써 해결이 가능하다.
     */
    @Bean
    public KafkaMessageListenerContainer<String, String> kafkaMessageListenerContainer(
            ConsumerFactory<String, String> containerFactory

    ) {
        String topic = "example";
        ContainerProperties containerProperties = new ContainerProperties(topic);
        containerProperties.setGroupId("consumer-container");
        containerProperties.setAckMode(ContainerProperties.AckMode.BATCH);
        containerProperties.setMessageListener(new DefaultMessageListener());

        KafkaMessageListenerContainer<String, String> container = new KafkaMessageListenerContainer<>(containerFactory, containerProperties);
        /**
         * 자동시작 설정 disable
         */
        //container.setAutoStartup(false);
        return container;
    }

    @Bean
    public ConsumerFactory<String, String> containerFactory() {
        Map<String, Object> properties = new LinkedHashMap<>();

        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BROKER_URL);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);


        return new DefaultKafkaConsumerFactory(properties);
    }
}
