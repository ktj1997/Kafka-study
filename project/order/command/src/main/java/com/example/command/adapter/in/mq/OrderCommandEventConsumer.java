package com.example.command.adapter.in.mq;

import com.example.command.adapter.in.mq.message.ShippingAddressChangedMessage;
import com.example.command.adapter.in.mq.message.ShippingStatusChangedMessage;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;

public interface OrderCommandEventConsumer {
  void consume(@Payload ShippingAddressChangedMessage message, Acknowledgment ack);

  void consume(@Payload ShippingStatusChangedMessage message, Acknowledgment ack);

}
