package com.example.query.application.service.query.dispatcher;

import com.example.core.domain.BaseEntity;
import com.example.core.exceptions.ApiException;
import com.example.core.exceptions.GlobalErrorCode;
import com.example.query.application.service.query.BaseQuery;
import com.example.query.application.service.query.handler.QueryHandlerMethod;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class OrderQueryDispatcher implements QueryDispatcher {
  private final Map<Class<? extends BaseQuery>, List<QueryHandlerMethod>> routes = new HashMap<>();

  @Override
  public <T extends BaseQuery> void registerHandler(Class<T> type, QueryHandlerMethod<T> handler) {

    var handlers = routes.computeIfAbsent(type, command -> new LinkedList<>());
    handlers.add(handler);
  }

  @Override
  public <T extends BaseEntity> List<T> send(BaseQuery query) {
    var handlers = routes.get(query.getClass());
    if (handlers == null || handlers.size() == 0)
      throw new ApiException(
          GlobalErrorCode.INTERNAL_SERVER_ERROR.getCode(), "No Command Handler was registered");
    if (handlers.size() > 1)
      throw new ApiException(
          GlobalErrorCode.INTERNAL_SERVER_ERROR.getCode(),
          "Cannot Send command to more than one handler");

    return (List<T>)handlers.get(0).handle(query);
  }
}
