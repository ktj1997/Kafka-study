package com.example.order.adapter.in.rest.query;

import com.example.order.application.port.in.info.OrderInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderQueryController {

  private final GetOrderUseCase getOrderUseCase;

  @GetMapping("/{id}")
  public ResponseEntity<OrderInfo> getOrder(@PathVariable Long id) {
    return null;
  }
}
