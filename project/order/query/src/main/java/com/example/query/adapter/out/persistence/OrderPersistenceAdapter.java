package com.example.query.adapter.out.persistence;

import com.example.core.exceptions.EntityNotFoundException;
import com.example.core.exceptions.GlobalErrorCode;
import com.example.query.domain.entity.Order;
import com.example.query.adapter.out.persistence.repository.OrderRepository;
import com.example.query.application.port.out.persistence.OrderDataAccessor;
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
