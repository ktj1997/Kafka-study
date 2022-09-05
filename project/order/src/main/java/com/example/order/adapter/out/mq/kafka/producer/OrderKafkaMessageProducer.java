package com.example.order.adapter.out.mq.kafka.producer;

import com.example.order.adapter.out.mq.kafka.config.KafkaTopicConstant;
import com.example.order.adapter.out.mq.kafka.record.OrderCreatedRecord;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaProducerException;
import org.springframework.kafka.core.KafkaSendCallback;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderKafkaMessageProducer {

  private final ObjectMapper objectMapper;
  private final KafkaTemplate<String, String> kafkaTemplate;

  public void produceOrderCreatedEvent(OrderCreatedRecord record) {
    try {
      String json = objectMapper.writeValueAsString(record);
      ListenableFuture<SendResult<String, String>> sendResult =
          kafkaTemplate.send(KafkaTopicConstant.CREATE_ORDER, json);

      sendResult.addCallback(
          new KafkaSendCallback<>() {

            @Override
            public void onSuccess(SendResult<String, String> result) {
              ProducerRecord<String, String> producerRecord = result.getProducerRecord();
              log.info(
                  "Send {} to Topic {} Success!", producerRecord.value(), producerRecord.topic());
            }

            @Override
            public void onFailure(KafkaProducerException ex) {
              log.error("Error Occurred at Record: {}", ex.getFailedProducerRecord());
            }
          });
    } catch (Throwable throwable) {
      log.error("Produce Kafka Record Fail");
      throwable.printStackTrace();
    }
  }
}
