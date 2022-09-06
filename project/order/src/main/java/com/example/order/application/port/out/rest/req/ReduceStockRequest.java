package com.example.order.application.port.out.rest.req;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReduceStockRequest {
  private int quantity;
}
