package com.example.order.application.port.out;

import com.example.order.domain.Order;

public interface OrderDataAccessor {
  Order save(Order order);
}
