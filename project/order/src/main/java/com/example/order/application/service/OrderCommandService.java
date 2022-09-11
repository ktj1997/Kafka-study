package com.example.order.application.service;

import com.example.core.commands.CommandDispatcher;
import com.example.core.exceptions.ApiException;
import com.example.core.exceptions.GlobalErrorCode;
import com.example.order.application.port.in.OrderCommandUseCase;
import com.example.order.application.port.in.command.CreateOrderCommand;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderCommandService implements OrderCommandUseCase {

  private final CommandDispatcher dispatcher;

  @Override
  @Transactional
  public String createOrder(CreateOrderCommand command) {
    String id = UUID.randomUUID().toString();
    try {
      command.setId(id);
      dispatcher.send(command);

      return id;

    } catch (Throwable throwable) {
      throwable.printStackTrace();
      throw new ApiException(GlobalErrorCode.INTERNAL_SERVER_ERROR.getCode(),"Error while processing Create Order");
    }
  }
}
