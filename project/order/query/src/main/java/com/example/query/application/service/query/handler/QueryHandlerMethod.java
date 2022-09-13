package com.example.query.application.service.query.handler;

import com.example.core.domain.BaseEntity;
import com.example.query.application.service.query.BaseQuery;
import java.util.List;

@FunctionalInterface
public interface QueryHandlerMethod<T extends BaseQuery> {
  List<BaseEntity> handle(T query);
}
