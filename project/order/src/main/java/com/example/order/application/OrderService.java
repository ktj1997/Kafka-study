package com.example.order.application;

import com.example.order.adapter.out.mq.kafka.record.OrderCreatedEvent;
import com.example.order.application.port.in.OrderUseCase;
import com.example.order.application.port.in.command.ItemCommand;
import com.example.order.application.port.in.command.OrderCommand;
import com.example.order.application.port.in.info.OrderInfo;
import com.example.order.application.port.out.mq.OrderMessageProducer;
import com.example.order.application.port.out.persistence.OrderDataAccessor;
import com.example.order.application.port.out.rest.res.ItemDetailResponse;
import com.example.order.application.utils.TransactionIdGenerator;
import com.example.order.domain.Order;
import com.example.order.domain.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService implements OrderUseCase {

  private final OrderMessageProducer orderMessageProducer;
  private final OrderDataAccessor orderDataAccessor;

  private final ItemService itemService;

  @Override
  public OrderInfo createOrder(ItemCommand itemCommand, OrderCommand orderCommand) {
    String transactionId = TransactionIdGenerator.generate();

    Order order =
        orderDataAccessor.save(
            new Order(
                null,
                OrderStatus.CREATED,
                orderCommand.getUserId(),
                orderCommand.getUserName(),
                orderCommand.getAddress(),
                orderCommand.getPhoneNumber(),
                transactionId));

    ItemDetailResponse item = itemService.getItem(itemCommand.getItemId());
    int reduceStockCount =
        itemService.reduceStock(
            item.getItemId(),
            order.getUserId(),
            order.getTransactionId(),
            itemCommand.getQuantity());

    orderMessageProducer.produce(
        new OrderCreatedEvent(
            order.getId(), transactionId, itemCommand.getItemId(), itemCommand.getQuantity()));

    return new OrderInfo(
        order.getId(),
        transactionId,
        orderCommand.getUserName(),
        item.getItemId(),
        item.getItemName(),
        item.getPrice(),
        reduceStockCount,
        item.getPrice() * itemCommand.getQuantity());
  }
}
