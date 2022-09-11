package com.example.order.core.infrastructure.command;

import com.example.order.application.service.command.CancelOrderCommand;
import com.example.order.application.service.command.handler.CommandHandler;
import com.example.order.application.service.command.CreateOrderCommand;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CommandDispatcherConfig {
  private final CommandHandler commandHandler;
  private final CommandDispatcher commandDispatcher;

  @PostConstruct
  public void registerHandlers() {
    commandDispatcher.registerHandler(CreateOrderCommand.class, commandHandler::handle);
    commandDispatcher.registerHandler(CancelOrderCommand.class, commandHandler::handle);
  }
}
