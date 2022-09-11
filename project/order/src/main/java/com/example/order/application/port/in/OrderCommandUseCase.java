package com.example.order.application.port.in;

import com.example.order.adapter.in.rest.command.req.CreateOrderCommandRequest;

public interface OrderCommandUseCase {
  String createOrder(CreateOrderCommandRequest req);
}
