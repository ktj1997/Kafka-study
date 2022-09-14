package com.example.query.application.service.info;

import com.example.library.domain.vo.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemInfo {
  private Long itemId;

  private String itemName;

  private int price;

  private int quantity;

  public ItemInfo(Item item) {
    this.itemId = item.getItemId();
    this.itemName = item.getItemName();
    this.price = item.getPrice();
    this.quantity = item.getQuantity();
  }
}
