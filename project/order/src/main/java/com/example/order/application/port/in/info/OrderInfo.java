package com.example.order.application.port.in.info;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderInfo {
  public Long orderId;
  public String transactionId;
  public String buyerName;
  public Long itemId;
  public String itemName;
  public int unitPrice;
  public int quantity;
  public int totalPrice;
}
