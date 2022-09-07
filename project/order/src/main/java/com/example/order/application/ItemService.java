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

  public int reduceStock(Long itemId, String userId, String transactionId, int quantity) {
    ReduceStockRequest req = new ReduceStockRequest(userId, transactionId, quantity);
    return itemGateway.reduceStock(itemId, req);
  }
}
