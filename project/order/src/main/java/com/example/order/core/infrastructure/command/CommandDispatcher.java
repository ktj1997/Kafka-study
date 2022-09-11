package com.example.order.core.infrastructure.command;


/**
 * Command Mediator
 */
public interface CommandDispatcher {
  <T extends BaseCommand> void registerHandler(Class<T> type, CommandHandlerMethod<T> handler);

  void send(BaseCommand command);
}
