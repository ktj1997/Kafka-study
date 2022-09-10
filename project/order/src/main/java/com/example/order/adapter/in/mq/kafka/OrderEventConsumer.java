package com.example.order.adapter.in.mq.kafka;

import com.example.order.application.events.OrderCanceledEvent;
import com.example.order.application.events.OrderCreatedEvent;
import com.example.order.application.events.ShippingAddressChangedEvent;
import com.example.order.application.events.ShippingCompletedEvent;
import com.example.order.application.handler.events.EventHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@Transactional
@RequiredArgsConstructor
public class OrderEventConsumer implements EventConsumer {
  private final EventHandler eventHandler;

  @Override
  @KafkaListener(topics = "OrderCreatedEvent", groupId = "${spring.application.name}")
  public void consume(OrderCreatedEvent event, Acknowledgment ack) {
    eventHandler.handle(event);
    ack.acknowledge();
  }

  @Override
  @KafkaListener(topics = "OrderCanceledEvent", groupId = "${spring.application.name}")
  public void consume(OrderCanceledEvent event, Acknowledgment ack) {
    eventHandler.handle(event);
    ack.acknowledge();
  }

  @Override
  @KafkaListener(topics = "ShippingAddressChangedEvent", groupId = "${spring.application.name}")
  public void consume(ShippingAddressChangedEvent event, Acknowledgment ack) {
    eventHandler.handle(event);
    ack.acknowledge();
  }

  @Override
  @KafkaListener(topics = "ShippingCompletedEvent", groupId = "${spring.application.name}")
  public void consume(ShippingCompletedEvent event, Acknowledgment ack) {
    eventHandler.handle(event);
    ack.acknowledge();
  }
}
