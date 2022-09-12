package com.example.query.adapter.in.rest;

import com.example.query.application.port.in.OrderQueryUseCase;
import com.example.query.application.port.in.info.OrderInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderQueryController {

  private final OrderQueryUseCase orderQueryUseCase;

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<OrderInfo> getOrder(@PathVariable String id) {
    OrderInfo orderInfo = orderQueryUseCase.getOrder(id);
    return ResponseEntity.ok(orderInfo);
  }
}
