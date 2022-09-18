package com.example.query.application.service.event;

import com.example.library.event.object.OrderCanceledEvent;
import com.example.library.event.object.OrderCreatedEvent;
import com.example.library.event.object.ShippingAddressChangedEvent;
import com.example.library.event.object.ShippingStatusChangedEvent;
import com.example.library.vo.OrderStatus;
import com.example.library.vo.ShippingStatus;
import com.example.query.application.port.out.persistence.OrderDataAccessor;
import com.example.query.domain.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class OrderEventHandler implements EventHandler {

  private final OrderDataAccessor orderDataAccessor;

  @Override
  @Transactional
  public void handle(OrderCreatedEvent event) {
    Order order =
        Order.builder()
            .id(event.getId())
            .orderStatus(OrderStatus.CREATED)
            .shippingStatus(ShippingStatus.SHIPPING_PREPARE)
            .item(event.getItem())
            .buyer(event.getBuyer())
            .shipping(event.getShipping())
            .build();

    orderDataAccessor.save(order);
  }

  @Override
  @Transactional
  public void handle(OrderCanceledEvent event) {
    Order order = orderDataAccessor.findById(event.getId());
    order.cancel(event.getReason());
  }

  @Override
  @Transactional
  public void handle(ShippingAddressChangedEvent event) {
    Order order = orderDataAccessor.findById(event.getOrderId());
    order.updateShippingAddress(event.getShipping());
  }

  @Override
  @Transactional
  public void handle(ShippingStatusChangedEvent event) {
    Order order = orderDataAccessor.findById(event.getOrderId());
    order.updateShippingStatus(event.getShippingStatus());
  }
}
