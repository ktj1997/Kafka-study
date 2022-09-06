package com.example.order.application.port.out.rest.res;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ItemDetailResponse {
  private Long itemId;
  private String itemName;
  private int price;
  private int quantity;
}
