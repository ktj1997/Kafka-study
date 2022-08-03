package com.example.kafka.consumer.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;

@Slf4j
public class DefaultMessageListener implements MessageListener<String, String> {
    @Override
    public void onMessage(ConsumerRecord<String, String> data) {
        log.info("I'm Default Message Listener, {}", data.value());
    }
}
