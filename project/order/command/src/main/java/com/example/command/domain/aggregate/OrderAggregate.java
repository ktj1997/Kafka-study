package com.example.command.domain.aggregate;

import com.example.command.application.service.command.CancelOrderCommand;
import com.example.command.application.service.command.CreateOrderCommand;
import com.example.command.application.service.command.UpdateShippingAddressCommand;
import com.example.command.application.service.command.UpdateShippingStatusCommand;
import com.example.library.domain.vo.OrderStatus;
import com.example.library.event.object.OrderCanceledEvent;
import com.example.library.event.object.OrderCreatedEvent;
import com.example.library.event.object.ShippingAddressChangedEvent;
import com.example.library.event.object.ShippingStatusChangedEvent;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderAggregate extends AggregateRoot {

  private OrderStatus orderStatus;

  public OrderAggregate(CreateOrderCommand command) {
    raiseEvent(
        OrderCreatedEvent.builder()
            .id(command.getId())
            .item(command.getItem())
            .buyer(command.getBuyer())
            .shipping(command.getShipping())
            .createdAt(command.getCreatedAt())
            .build());
  }

  public void apply(OrderCreatedEvent event) {
    this.id = event.getId();
    this.orderStatus = OrderStatus.CREATED;
  }

  public void cancel(CancelOrderCommand command) {
    raiseEvent(
        OrderCanceledEvent.builder().id(command.getId()).reason(command.getReason()).build());
  }

  public void apply(OrderCanceledEvent event) {
    this.id = event.getId();
    this.orderStatus = OrderStatus.CANCELED;
  }

  public void updateShippingAddress(UpdateShippingAddressCommand command) {}

  public void apply(ShippingAddressChangedEvent event) {}

  public void updateShippingStatus(UpdateShippingStatusCommand command) {}

  public void apply(ShippingStatusChangedEvent event) {}
}
