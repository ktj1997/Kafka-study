package com.example.command.application.service.command.handler;

import com.example.command.adapter.out.persistence.mongo.OrderEventPersistenceAdapter;
import com.example.command.application.service.command.CancelOrderCommand;
import com.example.command.application.service.command.CreateOrderCommand;
import com.example.command.application.service.command.UpdateShippingAddressCommand;
import com.example.command.application.service.command.UpdateShippingStatusCommand;
import com.example.command.application.service.exception.AlreadyCanceledException;
import com.example.command.application.service.exception.ErrorCode;
import com.example.command.domain.aggregate.OrderAggregate;
import com.example.library.vo.OrderStatus;
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

  @Override
  public void handle(UpdateShippingAddressCommand command) {
  }

  @Override
  public void handle(UpdateShippingStatusCommand command) {

  }
}
