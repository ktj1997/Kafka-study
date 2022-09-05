package com.example.order.adapter.out.persistence;

import com.example.order.adapter.out.persistence.jpa.repository.OrderHistoryRepository;
import com.example.order.application.port.out.persistence.OrderHistoryDataAccessor;
import com.example.order.domain.OrderHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@RequiredArgsConstructor
public class OrderHistoryPersistenceAdaptor implements OrderHistoryDataAccessor {

  private final OrderHistoryRepository orderHistoryRepository;

  @Override
  public OrderHistory save(OrderHistory orderHistory) {
    return orderHistoryRepository.save(orderHistory);
  }
}
