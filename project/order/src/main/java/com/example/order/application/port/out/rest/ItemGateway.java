package com.example.order.application.port.out.rest;

import com.example.order.application.port.out.rest.req.ReduceStockRequest;
import com.example.order.application.port.out.rest.res.ItemDetailResponse;

public interface ItemGateway {

  ItemDetailResponse getItemDetail(Long id);

  boolean reduceStock(Long id, ReduceStockRequest req);
}
