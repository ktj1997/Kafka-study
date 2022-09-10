package com.example.order.domain.vo;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class CancelInfo {
  @Column(name = "cancel_reason")
  private String reason;

  @Column(name = "canceled_at")
  private LocalDateTime canceledAt;
}
