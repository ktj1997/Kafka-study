package com.example.command.application.service.command.dispatcher;


import com.example.command.application.service.command.BaseCommand;
import com.example.command.application.service.command.handler.CommandHandlerMethod;

/**
 * Command Mediator
 */
public interface CommandDispatcher {
  <T extends BaseCommand> void registerHandler(Class<T> type, CommandHandlerMethod<T> handler);

  void send(BaseCommand command);
}
