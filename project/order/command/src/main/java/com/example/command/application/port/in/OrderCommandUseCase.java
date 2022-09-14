package com.example.command.application.port.in;

import com.example.command.application.port.in.dto.CreateOrderCommandDto;

public interface OrderCommandUseCase {
  CreateOrderCommandDto.Response createOrder(CreateOrderCommandDto.Request dto);
}
