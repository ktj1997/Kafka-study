package com.example.order.application.port.out.mq;

import com.example.order.config.mq.Message;

public interface OrderMessageProducer {

  void produce(Message message);
}
