package com.example.order.application.service.command.handler;

import com.example.order.adapter.out.persistence.mongo.OrderEventPersistenceAdapter;
import com.example.order.application.exceptions.AlreadyCanceledException;
import com.example.order.application.exceptions.ErrorCode;
import com.example.order.application.service.command.CancelOrderCommand;
import com.example.order.application.service.command.CreateOrderCommand;
import com.example.order.domain.OrderAggregate;
import com.example.order.domain.vo.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderCommandHandler implements CommandHandler {

  private final OrderEventPersistenceAdapter eventSourcingHandler;

  @Override
  public void handle(CreateOrderCommand command) {
    OrderAggregate aggregate = new OrderAggregate(command);
    eventSourcingHandler.save(aggregate);
  }

  @Override
  public void handle(CancelOrderCommand command) {
    OrderAggregate aggregate = eventSourcingHandler.getById(command.getId());
    if (aggregate.getOrderStatus().equals(OrderStatus.CANCELED))
      throw new AlreadyCanceledException(ErrorCode.ALREADY_CANCELED);
    aggregate.cancel(command);
    eventSourcingHandler.save(aggregate);
  }
}
