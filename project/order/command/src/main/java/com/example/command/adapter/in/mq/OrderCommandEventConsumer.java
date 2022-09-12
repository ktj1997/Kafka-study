package com.example.command.adapter.in.mq;

import com.example.command.application.port.out.mq.ShippingAddressChangedEvent;
import com.example.command.application.port.out.mq.ShippingStatusChangedEvent;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;

public interface OrderCommandEventConsumer {
  void consume(@Payload ShippingAddressChangedEvent event, Acknowledgment ack);

  void consume(@Payload ShippingStatusChangedEvent event, Acknowledgment ack);

}
