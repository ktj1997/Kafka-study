package com.example.order.application.port.out.rest;

import com.example.order.application.port.out.rest.res.ItemDetailResponse;
import com.example.order.application.port.out.rest.req.ReduceStockRequest;

public interface ItemGateway {

  ItemDetailResponse getItemDetail(Long id);

  int reduceStock(Long id, ReduceStockRequest req);
}
