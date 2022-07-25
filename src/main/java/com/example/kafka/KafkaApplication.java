package com.example.kafka;

import com.example.kafka.producer.KafkaTemplateProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;

@EnableKafka
@SpringBootApplication
@RequiredArgsConstructor
public class KafkaApplication {

    private final KafkaTemplateProducer kafkaKafkaTemplateProducer;

    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }

    @Bean
    public ApplicationRunner runner(KafkaTemplate<String, String> kafkaTemplate) {
        System.out.println("Start");
        return args -> {
           kafkaKafkaTemplateProducer.asyncSend("topic3","async");
           kafkaKafkaTemplateProducer.syncSend("topic3","sync");
           Thread.sleep(10000);
        };
    }
}
