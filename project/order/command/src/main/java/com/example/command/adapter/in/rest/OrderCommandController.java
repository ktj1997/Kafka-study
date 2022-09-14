package com.example.command.adapter.in.rest;


import com.example.command.adapter.in.rest.req.CreateOrderCommandRequest;
import com.example.command.application.port.in.OrderCommandUseCase;
import com.example.command.application.port.in.dto.CreateOrderCommandDto;
import com.example.command.application.port.in.dto.CreateOrderCommandDto.Request;
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
  private final OrderCommandUseCase orderCommandUseCase;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<CreateOrderCommandDto.Response> createOrder(@RequestBody CreateOrderCommandRequest req) {
    CreateOrderCommandDto.Request reqDto = new Request(req);
    CreateOrderCommandDto.Response resDto = orderCommandUseCase.createOrder(reqDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(resDto);
  }
}
