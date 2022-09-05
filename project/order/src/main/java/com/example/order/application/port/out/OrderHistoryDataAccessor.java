package com.example.order.application.port.out;

import com.example.order.domain.OrderHistory;

public interface OrderHistoryDataAccessor {
  OrderHistory save(OrderHistory orderHistory);
}
