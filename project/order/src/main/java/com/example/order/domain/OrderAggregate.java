package com.example.order.domain;

import com.example.core.domain.AggregateRoot;
import com.example.order.application.events.OrderCanceledEvent;
import com.example.order.application.port.in.command.CancelOrderCommand;
import com.example.order.application.events.OrderCreatedEvent;
import com.example.order.application.port.in.command.CreateOrderCommand;
import com.example.order.domain.vo.OrderStatus;
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

  public void apply(OrderCreatedEvent event){
    this.id = event.getId();
    this.orderStatus = OrderStatus.CREATED;
  }

  public void cancel(CancelOrderCommand command) {
    raiseEvent(
        OrderCanceledEvent.builder().id(command.getId()).reason(command.getReason()).build());
  }
  public void apply(OrderCanceledEvent event){
    this.id = event.getId();
    this.orderStatus = OrderStatus.CANCELED;
  }
}
