package com.example.order.adapter.in.mq.kafka;

import com.example.order.application.port.in.OrderHistoryUseCase;
import com.example.order.config.mq.kafka.KafkaTopicConstant;
import com.example.order.adapter.out.mq.kafka.record.OrderCreatedEvent;
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
  private final OrderHistoryUseCase orderHistoryUseCase;

  @KafkaListener(
      id = "order-created-event-consumer",
      topics = KafkaTopicConstant.CREATE_ORDER,
      groupId = "order-api")
  public void consumeOrderCreatedEvent(ConsumerRecord<String, String> consumerRecord) {
    try {

      log.info("Consume Record {} from topic: {}", consumerRecord.value(), consumerRecord.topic());
      OrderCreatedEvent orderCreatedEvent =
          objectMapper.readValue(consumerRecord.value(), OrderCreatedEvent.class);

      orderHistoryUseCase.saveOrderHistory(
          orderCreatedEvent.getOrderId(), orderCreatedEvent.getTransactionId());

    } catch (Throwable throwable) {
      log.error("Consume Kafka Record Failed");
      throwable.printStackTrace();
    }
  }
}
