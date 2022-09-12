package com.example.query.application.port.in;

import com.example.query.application.port.in.info.OrderInfo;

public interface OrderQueryUseCase {
  OrderInfo getOrder(String id);
}
