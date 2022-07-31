package com.example.kafka.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReplyingKafkaConsumer {

    @KafkaListener(id = "id", topics = "topic")
    @SendTo
    public String consume(String record) {
        log.info("Consume Record = {}", record);
        return "I Consume Your Record " + record;
    }
}
