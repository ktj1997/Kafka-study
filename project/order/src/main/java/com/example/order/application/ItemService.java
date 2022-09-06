package com.example.order.application;

import com.example.order.application.port.out.rest.ItemGateway;
import com.example.order.application.port.out.rest.req.ReduceStockRequest;
import com.example.order.application.port.out.rest.res.ItemDetailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {
  private final ItemGateway itemGateway;

  public ItemDetailResponse getItem(Long itemId) {
    return itemGateway.getItemDetail(itemId);
  }

  public boolean reduceStock(Long id, int quantity) {
    ReduceStockRequest req = new ReduceStockRequest(quantity);
    return itemGateway.reduceStock(id, req);
  }
}
