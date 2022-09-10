package com.example.order.adapter.in.mq.kafka;

import com.example.order.application.events.OrderCanceledEvent;
import com.example.order.application.events.OrderCreatedEvent;
import com.example.order.application.events.ShippingAddressChangedEvent;
import com.example.order.application.events.ShippingCompletedEvent;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;

public interface EventConsumer {
  void consume(@Payload OrderCreatedEvent event, Acknowledgment ack);

  void consume(@Payload OrderCanceledEvent event, Acknowledgment ack);

  void consume(@Payload ShippingAddressChangedEvent event, Acknowledgment ack);

  void consume(@Payload ShippingCompletedEvent event, Acknowledgment ack);
}
