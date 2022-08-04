package com.example.kafka.consumer.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.adapter.ConsumerRecordMetadata;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DefaultConsumer {

    /**
     * ConsumerRecordMetaData: Record Header 정보
     * <p>
     * id: Consumer-Group-id
     * concurrency:  쓰레드
     * clientIdPrefix: 기존에는 GroupId가 prefix로 붙지만 바꿀 수 있다.
     */
    @KafkaListener(id = "default-consumer", topics = "example", concurrency = "2", clientIdPrefix = "<default-consumer>")
    public void listen(
            ConsumerRecordMetadata consumerRecordMetadata,
            ConsumerRecord<String, String> consumerRecord) {
        log.info("Topic: {}, Partition: {}, offset: {}", consumerRecordMetadata.topic(), consumerRecordMetadata.partition(), consumerRecordMetadata.offset());
        log.info("Consume Message at {}", consumerRecord.timestamp());
        log.info("Consume Value : {}", consumerRecord.value());
    }
}
