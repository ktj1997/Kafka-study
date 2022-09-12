package com.example.command.application.service.command.dispatcher;

import com.example.command.application.service.command.CancelOrderCommand;
import com.example.command.application.service.command.CreateOrderCommand;
import com.example.command.application.service.command.handler.CommandHandler;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CommandDispatcherRegister {
  private final CommandHandler commandHandler;
  private final CommandDispatcher commandDispatcher;

  @PostConstruct
  public void registerHandlers() {
    commandDispatcher.registerHandler(CreateOrderCommand.class, commandHandler::handle);
    commandDispatcher.registerHandler(CancelOrderCommand.class, commandHandler::handle);
  }
}
