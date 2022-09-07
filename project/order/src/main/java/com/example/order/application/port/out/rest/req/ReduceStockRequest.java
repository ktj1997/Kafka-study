package com.example.order.application.port.out.rest.req;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReduceStockRequest {
  private String userId;
  private String transactionId;
  private int quantity;
}
