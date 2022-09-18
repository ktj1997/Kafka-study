package com.example.command.adapter.out.mq;

import com.example.library.event.object.BaseEvent;
import com.example.library.event.producer.EventProducer;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
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

  private final KafkaTemplate<String, BaseEvent> kafkaTemplate;

  @Override
  public void produce(String topic, BaseEvent event) {
    try {
      ListenableFuture<SendResult<String, BaseEvent>> sendResult =
          kafkaTemplate.send(topic, event);

      sendResult.addCallback(
          new KafkaSendCallback<>() {

            @Override
            public void onSuccess(SendResult<String, BaseEvent> result) {
              ProducerRecord<String, BaseEvent> producerRecord = result.getProducerRecord();
              RecordMetadata metadata = result.getRecordMetadata();
              log.info(
                  "{} Send {} to Topic {} Success!",metadata.timestamp(),producerRecord.value(), producerRecord.topic());
              log.info("Partition : {}, offset: {}",metadata.offset(),metadata.offset());
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
