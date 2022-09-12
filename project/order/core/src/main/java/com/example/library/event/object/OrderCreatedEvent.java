package com.example.library.event.object;

import com.example.library.domain.vo.Buyer;
import com.example.library.domain.vo.Item;
import com.example.library.domain.vo.Shipping;
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
