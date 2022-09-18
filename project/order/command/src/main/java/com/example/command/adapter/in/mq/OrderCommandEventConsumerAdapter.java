package com.example.command.adapter.in.mq;

import com.example.command.adapter.in.mq.message.ShippingAddressChangedMessage;
import com.example.command.adapter.in.mq.message.ShippingStatusChangedMessage;
import com.example.command.application.service.command.UpdateShippingAddressCommand;
import com.example.command.application.service.command.UpdateShippingStatusCommand;
import com.example.command.application.service.command.dispatcher.CommandDispatcher;
import com.example.library.vo.Shipping;
import com.example.library.vo.ShippingStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderCommandEventConsumerAdapter implements OrderCommandEventConsumer {

  private final CommandDispatcher dispatcher;

  @Override
  public void consume(ShippingAddressChangedMessage message, Acknowledgment ack) {
    Shipping shipping =
        new Shipping(message.getPostNo(), message.getStreetAddress(), message.getAddressDetail());
    UpdateShippingAddressCommand command =
        new UpdateShippingAddressCommand(message.getOrderId(), shipping);
    dispatcher.send(command);
    ack.acknowledge();
  }

  @Override
  public void consume(ShippingStatusChangedMessage message, Acknowledgment ack) {
    ShippingStatus shippingStatus = ShippingStatus.valueOf(message.getShippingStatus());
    UpdateShippingStatusCommand command =
        new UpdateShippingStatusCommand(message.getOrderId(), shippingStatus);
    dispatcher.send(command);
    ack.acknowledge();
  }
}
