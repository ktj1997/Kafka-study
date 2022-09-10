package com.example.order.adapter.out.rest;

import com.example.order.application.port.out.rest.res.ItemDetailResponse;
import com.example.order.adapter.out.rest.client.ItemClient;
import com.example.order.application.port.out.rest.ItemGateway;
import com.example.order.application.port.out.rest.req.ReduceStockRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ItemGatewayImpl implements ItemGateway {

  private final ItemClient itemClient;

  @Override
  public ItemDetailResponse getItemDetail(Long id) {
    return itemClient.getItemDetail(id);
  }

  @Override
  public int reduceStock(Long id, ReduceStockRequest req) {
    return itemClient.reduceStock(id, req);
  }
}
