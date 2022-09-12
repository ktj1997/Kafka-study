package com.example.query.application.service;

import com.example.query.application.port.in.OrderQueryUseCase;
import com.example.query.application.port.in.info.OrderInfo;
import com.example.query.application.port.out.persistence.OrderDataAccessor;
import com.example.query.domain.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderQueryService implements OrderQueryUseCase {

  private final OrderDataAccessor orderDataAccessor;

  @Override
  public OrderInfo getOrder(String id) {
    Order order = orderDataAccessor.findById(id);
    return new OrderInfo(order);
  }
}
