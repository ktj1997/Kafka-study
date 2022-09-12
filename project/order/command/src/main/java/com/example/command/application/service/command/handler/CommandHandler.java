package com.example.command.application.service.command.handler;


import com.example.command.application.service.command.CancelOrderCommand;
import com.example.command.application.service.command.CreateOrderCommand;
import com.example.command.application.service.command.UpdateShippingAddressCommand;
import com.example.command.application.service.command.UpdateShippingStatusCommand;

public interface CommandHandler {
  void handle(CreateOrderCommand command);

  void handle(CancelOrderCommand command);

  void handle(UpdateShippingAddressCommand command);

  void handle(UpdateShippingStatusCommand command);
}
