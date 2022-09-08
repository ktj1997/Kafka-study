package com.example.order.application;

import com.example.order.application.port.in.OrderHistoryUseCase;
import com.example.order.application.port.in.info.OrderHistoryInfo;
import com.example.order.application.port.out.persistence.OrderHistoryDataAccessor;
import com.example.order.domain.entity.OrderHistory;
import com.example.order.domain.OrderStatus;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderHistoryService implements OrderHistoryUseCase {

  private final OrderHistoryDataAccessor orderHistoryDataAccessor;

  @Override
  public List<OrderHistoryInfo> findAllHistories(Long orderId, String transactionId) {
    return orderHistoryDataAccessor.findAll(orderId, transactionId).stream()
        .map(history -> new OrderHistoryInfo(history.getOrderStatus(), history.getCreatedAt()))
        .collect(Collectors.toList());
  }

  @Override
  public OrderHistoryInfo saveOrderHistory(Long orderId, String transactionId) {
    OrderHistory orderHistory =
        orderHistoryDataAccessor.save(
            new OrderHistory(null, orderId, transactionId, OrderStatus.CREATED));

    return new OrderHistoryInfo(orderHistory.getOrderStatus(), orderHistory.createdAt);
  }
}
