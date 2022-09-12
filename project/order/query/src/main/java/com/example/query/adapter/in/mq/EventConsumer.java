package com.example.query.adapter.in.mq;

import com.example.library.event.object.OrderCanceledEvent;
import com.example.library.event.object.OrderCreatedEvent;
import com.example.library.event.object.ShippingAddressChangedEvent;
import com.example.library.event.object.ShippingStatusChangedEvent;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;

public interface EventConsumer {
  void consume(@Payload OrderCreatedEvent event, Acknowledgment ack);

  void consume(@Payload OrderCanceledEvent event, Acknowledgment ack);

  void consume(@Payload ShippingAddressChangedEvent event, Acknowledgment ack);

  void consume(@Payload ShippingStatusChangedEvent event, Acknowledgment ack);
}
