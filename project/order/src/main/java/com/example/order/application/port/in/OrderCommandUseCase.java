package com.example.order.application.port.in;

import com.example.order.application.port.in.command.CreateOrderCommand;

public interface OrderCommandUseCase {
  String createOrder(CreateOrderCommand command);
}
