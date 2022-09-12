package com.example.command.application.service.command.dispatcher;

import com.example.command.application.service.command.BaseCommand;

@FunctionalInterface
public interface CommandHandlerMethod<T extends BaseCommand> {
  void handle(T command);
}
