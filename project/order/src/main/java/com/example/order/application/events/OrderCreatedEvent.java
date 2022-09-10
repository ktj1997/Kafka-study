package com.example.order.application.events;

import com.example.core.events.BaseEvent;
import com.example.order.domain.vo.Buyer;
import com.example.order.domain.vo.Item;
import com.example.order.domain.vo.Shipping;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreatedEvent extends BaseEvent {
  private Item item;
  private Buyer buyer;
  private Shipping shipping;
  private LocalDateTime createdAt;
}
