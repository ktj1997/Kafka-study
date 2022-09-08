package com.example.order.application.port.out.persistence;

import com.example.order.domain.entity.Order;

public interface OrderDataAccessor {
  Order findById(Long id);

  Order save(Order order);
}
