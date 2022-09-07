package com.example.item.application.port.in.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReduceStockCommand {
  private Long itemId;
  private String userId;
  private String transactionId;
  private int quantity;
}
