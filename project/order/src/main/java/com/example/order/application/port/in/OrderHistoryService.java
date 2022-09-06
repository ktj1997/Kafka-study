package com.example.order.application.port.in;

import com.example.order.application.port.in.info.OrderHistoryInfo;
import com.example.order.domain.OrderHistory;
import java.util.List;

public interface OrderHistoryService {
  List<OrderHistoryInfo> findAllHistories(Long orderId, String transactionId);

  OrderHistoryInfo saveOrderHistory(Long orderId, String transactionId);
}
