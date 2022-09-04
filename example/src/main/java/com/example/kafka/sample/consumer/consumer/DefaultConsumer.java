package com.example.kafka.sample.consumer.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.listener.adapter.ConsumerRecordMetadata;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
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
     *
     * @Header를 통해서 KafkaHeader의 Property에 접근 할 수 있다.
     */
    @KafkaListener(id = "default-consumer", topics = "example", concurrency = "2", clientIdPrefix = "<default-consumer>")
    public void listen(
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
            ConsumerRecordMetadata consumerRecordMetadata,
            ConsumerRecord<String, String> consumerRecord) {
        log.info("Topic: {}, Partition: {}, offset: {}", consumerRecordMetadata.topic(), partition, consumerRecordMetadata.offset());
        log.info("Consume Message at {}", consumerRecord.timestamp());
        log.info("Consume Value : {}", consumerRecord.value());
    }

    /**
     * topicPartitions를 통해서 ContainerFactory, Partition별 시작 Offset등 별도의 설정을 추가 할 수 있다.
     * initialOffset부터 현재 Offset까지 모두 읽는다.
     */
    @KafkaListener(
            id = "initial-group",
            topicPartitions = @TopicPartition(topic = "topicName",
                    partitionOffsets = {
                            @PartitionOffset(partition = "0", initialOffset = "0"),
                            @PartitionOffset(partition = "3", initialOffset = "0")}),
            containerFactory = "concurrentKafkaListenerContainerFactory"
    )
    public void listenToPartition(
            @Header(KafkaHeaders.OFFSET) int offset,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
            ConsumerRecord<String, String> consumerRecord
    ) {
        log.info("Partition : {} & Offset : {} & Value : {}", partition, offset,consumerRecord.value());
    }
}