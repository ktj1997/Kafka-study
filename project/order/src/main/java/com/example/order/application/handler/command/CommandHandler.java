package com.example.order.application.handler.command;

import com.example.order.application.port.in.command.CancelOrderCommand;
import com.example.order.application.port.in.command.CreateOrderCommand;

public interface CommandHandler {
  void handle(CreateOrderCommand command);

  void handle(CancelOrderCommand command);
}
