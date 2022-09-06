package com.example.order.application.port.out.rest;

import com.example.order.application.port.out.rest.req.ReduceStockRequest;

public interface ItemGateway {
  void reduceStock(Long id, ReduceStockRequest req);
}
