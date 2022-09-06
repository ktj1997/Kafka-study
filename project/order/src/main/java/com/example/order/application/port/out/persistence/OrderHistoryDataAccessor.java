package com.example.order.application.port.out.persistence;

import com.example.order.domain.OrderHistory;
import java.util.List;

public interface OrderHistoryDataAccessor {

  List<OrderHistory> findAll(Long orderId, String transactionId);

  OrderHistory save(OrderHistory orderHistory);
}
