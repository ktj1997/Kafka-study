package com.example.item.application.port.in.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class ReduceStockCommandDto {
  @Getter
  @AllArgsConstructor
  public static class Request {
    private Long itemId;
    private String userId;
    private String transactionId;
    private int requestQuantity;
  }
}
