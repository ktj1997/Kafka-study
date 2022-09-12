package com.example.command.application.port.out.persistence.mongo;


import com.example.command.domain.aggregate.AggregateRoot;

public interface EventSourcingHandler<T> {
  void save(AggregateRoot aggregate);

  T getById(String id);
}
