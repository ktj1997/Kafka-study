package com.example.query.application.service.info;

import com.example.library.domain.vo.CancelInfo;
import com.example.library.domain.vo.OrderStatus;
import java.time.LocalDateTime;
import javax.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderInfo {
  private int totalPrice;
  private OrderStatus orderStatus;
  private String cancelReason;

  private LocalDateTime orderedAt;
  private LocalDateTime canceledAt;

  @Builder
  public OrderInfo(
      OrderStatus orderStatus, LocalDateTime orderedAt, CancelInfo cancelInfo, int totalPrice) {
    this.totalPrice = totalPrice;
    this.orderStatus = orderStatus;
    this.orderedAt = orderedAt;
    this.cancelReason = cancelInfo.getReason();
    this.canceledAt = cancelInfo.getCanceledAt();
  }
}
