package com.example.command.domain.aggregate;

import com.example.command.application.service.command.CancelOrderCommand;
import com.example.command.application.service.command.CreateOrderCommand;
import com.example.command.application.service.command.UpdateShippingAddressCommand;
import com.example.command.application.service.command.UpdateShippingStatusCommand;
import com.example.library.event.object.OrderCanceledEvent;
import com.example.library.event.object.OrderCreatedEvent;
import com.example.library.event.object.ShippingAddressChangedEvent;
import com.example.library.event.object.ShippingStatusChangedEvent;
import com.example.library.vo.Buyer;
import com.example.library.vo.Item;
import com.example.library.vo.OrderStatus;
import com.example.library.vo.Shipping;
import com.example.library.vo.ShippingStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderAggregate extends AggregateRoot {

  private Item item;
  private Buyer buyer;
  private Shipping shipping;
  private OrderStatus orderStatus;
  private ShippingStatus shippingStatus;

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
    this.buyer = event.getBuyer();
    this.shipping = event.getShipping();
    this.item = event.getItem();
    this.shippingStatus = ShippingStatus.SHIPPING_PREPARE;
  }

  public void cancel(CancelOrderCommand command) {
    raiseEvent(
        OrderCanceledEvent.builder().id(command.getId()).reason(command.getReason()).build());
  }

  public void apply(OrderCanceledEvent event) {
    this.id = event.getId();
    this.orderStatus = OrderStatus.CANCELED;
  }

  public void updateShippingAddress(UpdateShippingAddressCommand command) {
    raiseEvent(
        ShippingAddressChangedEvent.builder()
            .orderId(command.getOrderId())
            .shipping(command.getShipping())
            .build());
  }

  public void apply(ShippingAddressChangedEvent event) {
    this.id = event.getOrderId();
    this.shipping = event.getShipping();
  }

  public void updateShippingStatus(UpdateShippingStatusCommand command) {
    raiseEvent(
        ShippingStatusChangedEvent.builder()
            .orderId(command.getOrderId())
            .shippingStatus(command.getShippingStatus())
            .build()
    );
  }

  public void apply(ShippingStatusChangedEvent event) {
    this.id = event.getOrderId();
    this.shippingStatus = event.getShippingStatus();
  }
}
