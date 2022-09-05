package com.example.order.application.port.in.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ItemCommand {
  private Long itemId;
  private int quantity;
}
