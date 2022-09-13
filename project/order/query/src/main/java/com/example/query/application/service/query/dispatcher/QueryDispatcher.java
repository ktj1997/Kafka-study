package com.example.query.application.service.query.dispatcher;

import com.example.core.domain.BaseEntity;
import com.example.query.application.service.query.BaseQuery;
import com.example.query.application.service.query.handler.QueryHandlerMethod;
import java.util.List;

public interface QueryDispatcher {
  <T extends BaseQuery> void registerHandler(Class<T> type, QueryHandlerMethod<T> handler);

  <T extends BaseEntity> List<T> send(BaseQuery query);
}
