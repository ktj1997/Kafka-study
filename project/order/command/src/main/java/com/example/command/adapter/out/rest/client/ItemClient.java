package com.example.command.adapter.out.rest.client;

import com.example.command.adapter.out.rest.req.ReduceStockRequest;
import com.example.command.adapter.out.rest.res.ItemDetailResponse;
import com.example.config.rest.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "item-api", url = "${gateway.item}", configuration = FeignConfig.class)
public interface ItemClient {

  @GetMapping(ItemClientConstant.ITEM_DETAIL)
  ItemDetailResponse getItemDetail(@PathVariable Long itemId);

  @PostMapping(ItemClientConstant.STOCK_DECREASE)
  int reduceStock(@PathVariable Long itemId, @RequestBody ReduceStockRequest req);
}
