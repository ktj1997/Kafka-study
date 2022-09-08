package com.example.order.adapter.in.rest.command;

import com.example.order.adapter.in.rest.command.req.CreateOrderCommandRequest;
import com.example.order.application.port.in.AcceptOrderUseCase;
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
public class OrderCommandController {

  private final AcceptOrderUseCase acceptOrderUseCase;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<OrderInfo> acceptOrder(@RequestBody CreateOrderCommandRequest req) {
    OrderInfo info = acceptOrderUseCase.acceptOrder(req.getItem(), req.getOrder());

    return ResponseEntity.status(HttpStatus.CREATED).body(info);
  }
}
