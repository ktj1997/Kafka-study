package com.example.order.application.port.in.info;

import com.example.order.domain.OrderStatus;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderHistoryInfo {
  private OrderStatus status;
  private LocalDateTime createdAt;
}
