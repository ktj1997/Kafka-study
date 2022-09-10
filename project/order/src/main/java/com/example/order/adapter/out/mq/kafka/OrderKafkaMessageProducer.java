package com.example.order.adapter.out.mq.kafka;

import com.example.core.events.BaseEvent;
import com.example.core.events.EventProducer;
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
public class OrderKafkaMessageProducer implements EventProducer {

  private final ObjectMapper objectMapper;
  private final KafkaTemplate<String, String> kafkaTemplate;

  @Override
  public void produce(String topic, BaseEvent event) {
    try {
      String json = objectMapper.writeValueAsString(event);
      ListenableFuture<SendResult<String, String>> sendResult =
          kafkaTemplate.send(topic, json);

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
