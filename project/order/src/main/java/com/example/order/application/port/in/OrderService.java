package com.example.order.application.port.in;

import com.example.order.application.port.in.command.ItemCommand;
import com.example.order.application.port.in.command.OrderCommand;
import com.example.order.application.port.in.info.OrderInfo;

public interface OrderService {
  OrderInfo createOrder(ItemCommand itemCommand, OrderCommand orderCommand);
}
