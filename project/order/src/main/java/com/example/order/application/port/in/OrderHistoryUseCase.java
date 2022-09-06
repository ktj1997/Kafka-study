package com.example.order.application.port.in;

import com.example.order.application.port.in.info.OrderHistoryInfo;
import java.util.List;

public interface OrderHistoryUseCase {
  List<OrderHistoryInfo> findAllHistories(Long orderId, String transactionId);

  OrderHistoryInfo saveOrderHistory(Long orderId, String transactionId);
}
