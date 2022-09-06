package com.example.item.adapter.in.web;

import com.example.item.adapter.in.web.req.ReduceStockRequest;
import com.example.item.application.port.in.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {
  private final ItemService itemService;

  @PostMapping("/{id}/reduce/stock")
  public void reduceStock(@PathVariable Long id, @RequestBody ReduceStockRequest req) {

  }
}
