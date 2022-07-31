package com.example.kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaProducerException;
import org.springframework.kafka.core.KafkaSendCallback;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 가장 기본적인 KafkaTemplate을 통한 Send
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaTemplateProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void asyncSend(String topic, String message) {
        /**
         * ListenableFutureCallback은 어떤 에러가 발생했는지 밖에 알수 없기 때문에,
         * 해당 클래스를 상속한 KafkaSendCallback을 상속한다.
         */

        ListenableFuture<SendResult<String, String>> sendResult = kafkaTemplate.send(topic, message);

        sendResult.addCallback(new KafkaSendCallback<>() {

            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("Send Topic {} to {} Success!", topic, message);
            }

            @Override
            public void onFailure(KafkaProducerException ex) {
                log.error("Error Occured at Record: {}", ex.getFailedProducerRecord());
            }
        });
    }

    public void syncSend(String topic, String message) {
        ListenableFuture<SendResult<String, String>> sendResult = kafkaTemplate.send(topic, message);
        try {
            sendResult.get(5, TimeUnit.SECONDS);
            log.info("Send Topic {} to {} Success!", topic, message);
        } catch (ExecutionException | InterruptedException | TimeoutException e) {
            e.printStackTrace();
        }
    }
}
