package com.example.item.adapter.in.rest;

import com.example.item.adapter.in.rest.req.ReduceStockRequest;
import com.example.item.application.port.in.ItemUseCase;
import com.example.item.application.port.in.dto.ReduceStockCommandDto;
import com.example.item.application.service.command.ReduceStockCommand;
import com.example.item.application.port.in.dto.ItemInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {
  private final ItemUseCase itemUseCase;

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<ItemInfo> getItemDetail(@PathVariable Long id) {
    ItemInfo info = itemUseCase.getItemDetail(id);
    return ResponseEntity.ok(info);
  }

  @PostMapping("/{id}/reduce/stock")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Long> reduceStock(
      @PathVariable Long id, @RequestBody ReduceStockRequest req) {
    ReduceStockCommandDto.Request reqDto =
        new ReduceStockCommandDto.Request(
            id, req.getUserId(), req.getTransactionId(), req.getQuantity());
    long response = itemUseCase.reduceStock(reqDto);
    return ResponseEntity.ok(response);
  }
}
