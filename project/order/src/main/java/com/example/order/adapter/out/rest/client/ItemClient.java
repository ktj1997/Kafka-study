package com.example.order.adapter.out.rest.client;

import com.example.order.adapter.out.rest.ItemClientConstant;
import com.example.order.application.port.out.rest.req.ReduceStockRequest;
import com.example.order.config.rest.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@FeignClient(name = "item-api", url = "${gateway.item}", configuration = FeignConfig.class)
public interface ItemClient {
  @PostMapping(ItemClientConstant.STOCK_DECREASE)
  void reduceStock(@PathVariable Long itemId, @RequestBody ReduceStockRequest req);

}
