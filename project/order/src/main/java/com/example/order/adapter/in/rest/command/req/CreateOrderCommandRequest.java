package com.example.order.adapter.in.rest.command.req;

import com.example.order.application.port.in.command.ItemCommand;
import com.example.order.application.port.in.command.OrderCommand;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateOrderCommandRequest {
  private OrderCommand order;
  private ItemCommand item;
}
