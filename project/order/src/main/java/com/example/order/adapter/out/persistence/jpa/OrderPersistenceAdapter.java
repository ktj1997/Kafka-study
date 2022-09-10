package com.example.order.adapter.out.persistence.jpa;

import com.example.core.exceptions.EntityNotFoundException;
import com.example.core.exceptions.GlobalErrorCode;
import com.example.order.adapter.out.persistence.jpa.repository.OrderRepository;
import com.example.order.application.port.out.persistence.rdb.OrderDataAccessor;
import com.example.order.domain.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class OrderPersistenceAdapter implements OrderDataAccessor {
  private final OrderRepository orderRepository;

  @Override
  @Transactional(readOnly = true)
  public Order findById(String id) {
    return orderRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException(GlobalErrorCode.ENTITY_NOT_FOUND));
  }

  @Override
  @Transactional
  public Order save(Order order) {
    return orderRepository.save(order);
  }
}
