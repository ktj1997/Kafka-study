package com.example.order.application.service.events;

import com.example.order.application.events.OrderCanceledEvent;
import com.example.order.application.events.OrderCreatedEvent;
import com.example.order.application.events.ShippingAddressChangedEvent;
import com.example.order.application.events.ShippingCompletedEvent;

public interface EventHandler {
  void handle(OrderCreatedEvent event);

  void handle(OrderCanceledEvent event);

  void handle(ShippingAddressChangedEvent event);

  void handle(ShippingCompletedEvent event);
}
