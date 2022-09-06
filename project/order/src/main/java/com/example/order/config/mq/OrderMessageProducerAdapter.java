package com.example.order.config.mq;

import com.example.order.adapter.out.mq.kafka.OrderKafkaMessageProducer;
import com.example.order.adapter.out.mq.kafka.record.OrderCreatedRecord;
import com.example.order.application.port.out.mq.OrderMessageProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderMessageProducerAdapter implements OrderMessageProducer {
  private final OrderKafkaMessageProducer orderKafkaMessageProducer;

  @Override
  public void produce(Message message) {
    if (message instanceof OrderCreatedRecord) {
      orderKafkaMessageProducer.produceOrderCreatedEvent((OrderCreatedRecord) message);
    } else {
      throw new RuntimeException("Message가 정의되지 않아, Produce에 실패하였습니다");
    }
  }
}
