package com.example.order.adapter.in.rest.command;

import com.example.order.adapter.in.rest.command.req.CreateOrderCommandRequest;
import com.example.order.application.handler.command.CommandHandler;
import com.example.order.application.port.in.command.CreateOrderCommand;
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

  private final CommandHandler commandHandler;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Void> acceptOrder(@RequestBody CreateOrderCommandRequest req) {
    CreateOrderCommand command = req.toCommand();
    commandHandler.handle(command);

    return ResponseEntity.status(HttpStatus.CREATED).body(null);
  }
}
