package com.example.order.adapter.in.rest.command.req;

import com.example.order.application.port.in.command.CreateOrderCommand;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateOrderCommandRequest {
  private String userId;
  private String userName;
  private String address;
  private String phoneNumber;

  private Long itemId;
  private int quantity;

  public CreateOrderCommand toCommand(){

  }
}
