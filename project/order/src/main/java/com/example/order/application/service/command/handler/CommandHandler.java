package com.example.order.application.service.command.handler;

import com.example.order.application.service.command.CancelOrderCommand;
import com.example.order.application.service.command.CreateOrderCommand;

public interface CommandHandler {
  void handle(CreateOrderCommand command);

  void handle(CancelOrderCommand command);
}
