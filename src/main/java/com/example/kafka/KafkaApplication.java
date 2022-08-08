package com.example.kafka;

import com.example.kafka.producer.KafkaTemplateProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;

@Slf4j
@EnableKafka
@SpringBootApplication
public class KafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }

    @Bean
    public ApplicationRunner runner(
            KafkaTemplateProducer producer
    ) {
        return args -> {
            producer.asyncSend("topicName","hello");
            producer.asyncSend("topicName","bye");
            /**
             * Pause와 Resume을 통해서 Listen 여부를 결정한다.
             *
             * kafkaListenerContainerFactory.stop();
             * kafkaListenerContainerFactory.resume();
             */

        };
    }
}
