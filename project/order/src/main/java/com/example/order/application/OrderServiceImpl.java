package com.example.order.application;

import com.example.order.adapter.out.mq.kafka.record.OrderCreatedRecord;
import com.example.order.application.port.in.OrderService;
import com.example.order.application.port.in.command.ItemCommand;
import com.example.order.application.port.in.command.OrderCommand;
import com.example.order.application.port.in.info.OrderInfo;
import com.example.order.application.port.out.mq.OrderMessageProducer;
import com.example.order.application.port.out.persistence.OrderDataAccessor;
import com.example.order.application.port.out.persistence.OrderHistoryDataAccessor;
import com.example.order.application.utils.TransactionIdGenerator;
import com.example.order.domain.Order;
import com.example.order.domain.OrderHistory;
import com.example.order.domain.OrderHistoryId;
import com.example.order.domain.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

  private final OrderMessageProducer orderMessageProducer;
  private final OrderDataAccessor orderDataAccessor;
  private final OrderHistoryDataAccessor orderHistoryDataAccessor;

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

    OrderHistoryId orderHistoryId = new OrderHistoryId(order.getId(), transactionId);
    orderHistoryDataAccessor.save(new OrderHistory(orderHistoryId, OrderStatus.CREATED));

    orderMessageProducer.produce(
        new OrderCreatedRecord(
            order.getId(), transactionId, itemCommand.getItemId(), itemCommand.getQuantity()));

    return new OrderInfo(order.getId(), transactionId);
  }
}
