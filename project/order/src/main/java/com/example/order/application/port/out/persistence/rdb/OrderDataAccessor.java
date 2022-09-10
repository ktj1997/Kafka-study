package com.example.order.application.port.out.persistence.rdb;

import com.example.order.domain.entity.Order;

public interface OrderDataAccessor {
  Order findById(String id);

  Order save(Order order);
}
