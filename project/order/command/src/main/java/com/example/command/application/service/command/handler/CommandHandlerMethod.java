package com.example.command.application.service.command.handler;

import com.example.command.application.service.command.BaseCommand;

@FunctionalInterface
public interface CommandHandlerMethod<T extends BaseCommand> {
  void handle(T command);
}
