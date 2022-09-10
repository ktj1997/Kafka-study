package com.example.core.events;

public interface EventProducer {
  void produce(String topic, BaseEvent event);
}
