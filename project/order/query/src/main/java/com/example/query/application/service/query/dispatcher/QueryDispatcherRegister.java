package com.example.query.application.service.query.dispatcher;

import com.example.query.application.service.query.FindOrderByIdQuery;
import com.example.query.application.service.query.handler.QueryHandler;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class QueryDispatcherRegister {
  private final QueryHandler queryHandler;
  private final QueryDispatcher queryDispatcher;

  @PostConstruct
  public void registerHandlers() {
    queryDispatcher.registerHandler(FindOrderByIdQuery.class, queryHandler::handle);
  }
}
