package com.example.item.application.port.in.dto;

import com.example.item.domain.ItemStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ItemInfo {
  private Long itemId;
  private String itemName;
  private int price;
  private int stock;
  private ItemStatus status;
}
