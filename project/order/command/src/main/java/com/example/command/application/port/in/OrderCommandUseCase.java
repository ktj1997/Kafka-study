package com.example.command.application.port.in;


import com.example.command.adapter.in.rest.req.CreateOrderCommandRequest;

public interface OrderCommandUseCase {
  String createOrder(CreateOrderCommandRequest req);
}
