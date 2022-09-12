package com.example.query.application.service.event;

import com.example.library.event.object.OrderCanceledEvent;
import com.example.library.event.object.OrderCreatedEvent;
import com.example.library.event.object.ShippingAddressChangedEvent;
import com.example.library.event.object.ShippingStatusChangedEvent;

public interface EventHandler {
  void handle(OrderCreatedEvent event);

  void handle(OrderCanceledEvent event);

  void handle(ShippingAddressChangedEvent event);

  void handle(ShippingStatusChangedEvent event);
}
