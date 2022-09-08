package com.example.order.application.port.in;

import com.example.order.application.port.in.info.OrderInfo;

public interface GetOrderUseCase {

  OrderInfo getOrder(Long id);
}
