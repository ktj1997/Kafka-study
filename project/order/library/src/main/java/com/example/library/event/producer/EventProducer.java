package com.example.library.event.producer;

import com.example.library.event.object.BaseEvent;

public interface EventProducer {
  void produce(String topic, BaseEvent event);
}
