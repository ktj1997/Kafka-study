package com.example.order.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class OrderHistoryId implements Serializable {

  @Column(name = "order_id", nullable = false)
  private Long orderId;

  @Column(name = "transaction_id", nullable = false)
  private String transactionId;
}
