package com.example.command.adapter.in.mq;

import com.example.command.application.port.out.mq.ShippingAddressChangedEvent;
import com.example.command.application.port.out.mq.ShippingStatusChangedEvent;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class OrderCommandEventConsumerAdapter implements OrderCommandEventConsumer {

  @Override
  public void consume(ShippingAddressChangedEvent event, Acknowledgment ack) {}

  @Override
  public void consume(ShippingStatusChangedEvent event, Acknowledgment ack) {}
}
