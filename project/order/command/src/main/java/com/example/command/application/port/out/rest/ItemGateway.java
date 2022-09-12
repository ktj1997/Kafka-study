package com.example.command.application.port.out.rest;

import com.example.command.adapter.out.rest.req.ReduceStockRequest;
import com.example.command.adapter.out.rest.res.ItemDetailResponse;

public interface ItemGateway {

  ItemDetailResponse getItemDetail(Long id);

  int reduceStock(Long id, ReduceStockRequest req);
}
