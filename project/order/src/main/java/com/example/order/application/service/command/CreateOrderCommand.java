package com.example.order.application.service.command;

import com.example.order.core.infrastructure.command.BaseCommand;
import com.example.order.domain.vo.Buyer;
import com.example.order.domain.vo.Item;
import com.example.order.domain.vo.Shipping;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderCommand extends BaseCommand {
  private Buyer buyer;
  private Shipping shipping;
  private Item item;
  private LocalDateTime createdAt;
}
