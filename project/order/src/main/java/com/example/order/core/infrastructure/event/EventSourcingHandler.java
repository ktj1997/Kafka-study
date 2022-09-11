package com.example.order.core.infrastructure.event;


import com.example.order.core.infrastructure.domain.AggregateRoot;

public interface EventSourcingHandler<T> {
  void save(AggregateRoot aggregate);

  T getById(String id);
}
