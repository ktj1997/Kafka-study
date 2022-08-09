package com.example.kafka.sample.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.kafka.requestreply.RequestReplyFuture;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReplyingKafkaProducer {

    private final ReplyingKafkaTemplate<String, String, String> replyingKafkaTemplate;

    public void replyingSend() throws ExecutionException, InterruptedException, TimeoutException {
        String topic = "topic";
        String key = "key";
        String value = "value";

        ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(topic, key, value);
        RequestReplyFuture<String, String, String> response = replyingKafkaTemplate.sendAndReceive(producerRecord);
        log.info("Producer Produce topic: {} key: {}, value:{} ", topic, key, value);

        ConsumerRecord<String, String> consumerRecord = response.get(30, TimeUnit.SECONDS);

        log.info("Consumer Consume value: {}, offset: {}", consumerRecord.value(), consumerRecord.offset());
    }
}
