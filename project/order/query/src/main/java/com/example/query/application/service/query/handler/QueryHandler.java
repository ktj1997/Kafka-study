package com.example.query.application.service.query.handler;

import com.example.core.domain.BaseEntity;
import com.example.query.application.service.query.FindOrderByIdQuery;
import java.util.List;

public interface QueryHandler {
  List<BaseEntity> handle(FindOrderByIdQuery query);
}
