package com.example.order.application;

import com.example.order.application.port.in.OrderHistoryService;
import com.example.order.application.port.in.info.OrderHistoryInfo;
import com.example.order.application.port.out.persistence.OrderHistoryDataAccessor;
import com.example.order.domain.OrderHistory;
import com.example.order.domain.OrderHistoryId;
import com.example.order.domain.OrderStatus;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderHistoryServiceImpl implements OrderHistoryService {

  private final OrderHistoryDataAccessor orderHistoryDataAccessor;

  @Override
  public List<OrderHistoryInfo> findAllHistories(Long orderId, String transactionId) {
    return null;
  }

  @Override
  public OrderHistoryInfo saveOrderHistory(Long orderId, String transactionId) {
    OrderHistoryId orderHistoryId = new OrderHistoryId(orderId, transactionId);
    OrderHistory orderHistory =
        orderHistoryDataAccessor.save(new OrderHistory(orderHistoryId, OrderStatus.CREATED));

    return new OrderHistoryInfo(orderHistory.getStatus(), orderHistory.getCreatedAt());
  }
}
