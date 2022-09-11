package com.example.order.domain.vo;

import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Item {
  private Long itemId;
  private String itemName;
  private int price;
  private int quantity;
}
