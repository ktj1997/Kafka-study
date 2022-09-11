package com.example.order.adapter.in.mq.kafka.record;

import com.example.order.core.config.mq.Message;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderCanceledEvent extends Message {
  private Long orderId;
  private String transactionId;
  private Long itemId;
  private int quantity;
}
