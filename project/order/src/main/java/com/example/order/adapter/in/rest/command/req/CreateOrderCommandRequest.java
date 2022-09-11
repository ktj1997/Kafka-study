package com.example.order.adapter.in.rest.command.req;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateOrderCommandRequest {
  private String userId;
  private String userName;
  private String phoneNumber;

  private Long itemId;
  private int quantity;

  private Long shippingId;
}
