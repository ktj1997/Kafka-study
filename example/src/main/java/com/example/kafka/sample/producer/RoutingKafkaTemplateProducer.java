package com.example.kafka.sample.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaProducerException;
import org.springframework.kafka.core.KafkaSendCallback;
import org.springframework.kafka.core.RoutingKafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.Arrays;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoutingKafkaTemplateProducer {

    private final RoutingKafkaTemplate routingKafkaTemplate;

    public void sendBytes(String topic, byte[] message) {
        ListenableFuture<SendResult<Object, Object>> sendResult =
                routingKafkaTemplate.send("byte-array", message);

        sendResult.addCallback(new KafkaSendCallback<>(){

            @Override
            public void onSuccess(SendResult<Object, Object> result) {
                log.info("send topic: {} to message :{} success",topic, Arrays.toString(message));
            }

            @Override
            public void onFailure(KafkaProducerException ex) {

            }
        });
    }

    public void sendString(String topic, String message) {
        /**
         * RoutingKafkaTemplateConfiguration에서
         * "byte-array" 토픽은 ByteArraySerializer를 사용하는 KafkaTemplate을 사용하도록
         *  Routing 했기 때문에 에러가 발생할 것이다.
         */
        ListenableFuture<SendResult<Object, Object>> sendResult =
                routingKafkaTemplate.send("byte-array", "Error!");

        sendResult.addCallback(new KafkaSendCallback<>() {

            @Override
            public void onSuccess(SendResult<Object, Object> result) {
                log.error("Can't Success");
            }

            @Override
            public void onFailure(KafkaProducerException ex) {
                ex.printStackTrace();
            }
        });
    }
}
