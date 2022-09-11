package com.example.order.config.infrastructure.command;

import com.example.core.commands.CommandDispatcher;
import com.example.order.application.port.in.command.CancelOrderCommand;
import com.example.order.application.handler.command.CommandHandler;
import com.example.order.application.port.in.command.CreateOrderCommand;
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
