package com.example.command.adapter.in.mq;

import com.example.command.adapter.in.mq.message.ShippingAddressChangedMessage;
import com.example.command.adapter.in.mq.message.ShippingStatusChangedMessage;
import com.example.command.application.port.out.mq.ShippingAddressChangedEvent;
import com.example.command.application.port.out.mq.ShippingStatusChangedEvent;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class OrderCommandEventConsumerAdapter implements OrderCommandEventConsumer {
  @Override
  public void consume(ShippingAddressChangedMessage message, Acknowledgment ack) {

  }

  @Override
  public void consume(ShippingStatusChangedMessage message, Acknowledgment ack) {

  }
}
