package com.example.item.adapter.in.mq;

import com.example.item.config.mq.kafka.KafkaTopicConstant;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@Transactional
@RequiredArgsConstructor
public class OrderKafkaMessageConsumer {

  private final ObjectMapper objectMapper;

  @KafkaListener(
      id = "order-created-event-consumer",
      topics = KafkaTopicConstant.CANCEL_ORDER,
      groupId = "item-api")
  public void consumeOrderCanceledEvent(ConsumerRecord<String, String> consumerRecord) {

  }
}
