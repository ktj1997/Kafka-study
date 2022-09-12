package com.example.query.application.port.out.persistence;

import com.example.query.domain.entity.Order;

public interface OrderDataAccessor {
  Order findById(String id);

  Order save(Order order);
}
