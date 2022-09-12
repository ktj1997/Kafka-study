package com.example.library.domain.vo;

import javax.persistence.Column;
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
  @Column(name = "item_id")
  private Long itemId;

  @Column(name = "item_name")
  private String itemName;

  @Column(name = "price")
  private int price;

  @Column(name = "quantity")
  private int quantity;
}
