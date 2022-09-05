package com.example.order.application.port.out.mq;

import com.example.order.adapter.out.mq.Message;

public interface OrderMessageProducer {

  void produce(Message message);
}
