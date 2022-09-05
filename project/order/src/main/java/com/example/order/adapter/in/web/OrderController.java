package com.example.order.adapter.in.web;

import com.example.order.adapter.in.web.req.CreateOrderRequest;
import com.example.order.application.port.in.OrderService;
import com.example.order.application.port.in.info.OrderInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

  private final OrderService orderService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<OrderInfo> createOrder(@RequestBody CreateOrderRequest req) {
    OrderInfo info = orderService.createOrder(req.getItem(), req.getOrder());

    return ResponseEntity.status(HttpStatus.CREATED).body(info);
  }
}
