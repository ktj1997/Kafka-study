package com.example.order.application;

import com.example.order.application.port.in.GetOrderUseCase;
import com.example.order.application.port.in.info.OrderInfo;
import com.example.order.application.port.out.persistence.OrderDataAccessor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetOrderService implements GetOrderUseCase {

  private final OrderDataAccessor orderDataAccessor;

  @Override
  public OrderInfo getOrder(Long id) {
    return null;
  }
}
