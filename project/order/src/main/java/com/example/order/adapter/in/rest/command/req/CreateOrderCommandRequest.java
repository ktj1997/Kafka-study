package com.example.order.adapter.in.rest.command.req;

import com.example.order.application.port.in.command.CreateOrderCommand;
import com.example.order.domain.vo.Buyer;
import com.example.order.domain.vo.Item;
import com.example.order.domain.vo.Shipping;
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

  public CreateOrderCommand toCommand() {
    Buyer buyer = parseBuyer();
  }

  private Buyer parseBuyer() {
    return Buyer.builder().id(userId).name(userName).phoneNumber(phoneNumber).build();
  }


  private Item parseItem() {
    return Item.builder().itemId(itemId).quantity(ite)
  }
}
