package com.example.core.events;

import com.example.core.domain.AggregateRoot;

public interface EventSourcingHandler<T> {
  void save(AggregateRoot aggregate);

  T getById(String id);
}
