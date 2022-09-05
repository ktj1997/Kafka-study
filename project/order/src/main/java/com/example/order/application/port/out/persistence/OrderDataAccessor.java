package com.example.order.application.port.out.persistence;

import com.example.order.domain.Order;

public interface OrderDataAccessor {
  Order save(Order order);
}
