package com.example.command.application.service.command.dispatcher;

import com.example.command.application.service.command.BaseCommand;
import com.example.command.application.service.command.handler.CommandHandlerMethod;
import com.example.core.exceptions.ApiException;
import com.example.core.exceptions.GlobalErrorCode;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class OrderCommandDispatcher implements CommandDispatcher {
  private final Map<Class<? extends BaseCommand>, List<CommandHandlerMethod>> routes =
      new HashMap<>();

  @Override
  public <T extends BaseCommand> void registerHandler(
      Class<T> type, CommandHandlerMethod<T> handler) {

    var handlers = routes.computeIfAbsent(type, command -> new LinkedList<>());
    handlers.add(handler);
  }

  @Override
  public void send(BaseCommand command) {
    var handlers = routes.get(command.getClass());
    if (handlers == null || handlers.size() == 0)
      throw new ApiException(
          GlobalErrorCode.INTERNAL_SERVER_ERROR.getCode(), "No Command Handler was registered");
    if (handlers.size() > 1)
      throw new ApiException(
          GlobalErrorCode.INTERNAL_SERVER_ERROR.getCode(),
          "Cannot Send command to more than one handler");

    handlers.get(0).handle(command);
  }
}
