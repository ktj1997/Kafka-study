package com.example.order.application;

import com.example.order.adapter.out.mq.kafka.record.OrderCreatedEvent;
import com.example.order.application.port.in.AcceptOrderUseCase;
import com.example.order.application.port.in.command.ItemCommand;
import com.example.order.application.port.in.command.OrderCommand;
import com.example.order.application.port.in.info.OrderInfo;
import com.example.order.application.port.out.mq.OrderMessageProducer;
import com.example.order.application.port.out.persistence.OrderDataAccessor;
import com.example.order.application.port.out.rest.res.ItemDetailResponse;
import com.example.order.application.utils.TransactionIdGenerator;
import com.example.order.domain.entity.Order;
import com.example.order.domain.OrderStatus;
import com.example.order.domain.vo.Buyer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AcceptOrderService implements AcceptOrderUseCase {

  private final OrderMessageProducer orderMessageProducer;
  private final OrderDataAccessor orderDataAccessor;

  private final ItemService itemService;

  @Override
  public OrderInfo acceptOrder(ItemCommand itemCommand, OrderCommand orderCommand) {
    String transactionId = TransactionIdGenerator.generate();

    Buyer buyer =
        new Buyer(
            orderCommand.getUserId(), orderCommand.getUserName(), orderCommand.getPhoneNumber());

    Order order =
        orderDataAccessor.save(
            new Order(null, transactionId, OrderStatus.CREATED, buyer, orderCommand.getAddress()));

    ItemDetailResponse item = itemService.getItem(itemCommand.getItemId());
    int reduceStockCount =
        itemService.reduceStock(
            item.getItemId(),
            order.getBuyer().getName(),
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
