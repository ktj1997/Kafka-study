package com.example.order.adapter.out.persistence;

import com.example.order.adapter.out.persistence.jpa.repository.OrderRepository;
import com.example.order.application.port.out.persistence.OrderDataAccessor;
import com.example.order.config.exceptions.EntityNotFoundException;
import com.example.order.config.exceptions.ErrorCode;
import com.example.order.domain.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@RequiredArgsConstructor
public class OrderPersistenceAdaptor implements OrderDataAccessor {

  private final OrderRepository orderRepository;

  @Override
  public Order findById(Long id) {
    return orderRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException(ErrorCode.ENTITY_NOT_FOUND));
  }

  @Override
  public Order save(Order order) {
    return orderRepository.save(order);
  }
}
