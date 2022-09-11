package com.example.order.application.service.events;

import com.example.order.application.events.OrderCanceledEvent;
import com.example.order.application.events.OrderCreatedEvent;
import com.example.order.application.events.ShippingAddressChangedEvent;
import com.example.order.application.events.ShippingCompletedEvent;
import com.example.order.application.port.out.persistence.rdb.OrderDataAccessor;
import com.example.order.domain.entity.Order;
import com.example.order.domain.vo.OrderStatus;
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
            .status(OrderStatus.CREATED)
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
  public void handle(ShippingAddressChangedEvent event) {}

  @Override
  public void handle(ShippingCompletedEvent event) {}
}
