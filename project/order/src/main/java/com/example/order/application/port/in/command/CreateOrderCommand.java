package com.example.order.application.port.in.command;

import com.example.core.commands.BaseCommand;
import com.example.order.domain.vo.Buyer;
import com.example.order.domain.vo.Item;
import com.example.order.domain.vo.Shipping;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateOrderCommand extends BaseCommand {
  private Buyer buyer;
  private Shipping shipping;
  private Item item;
  private LocalDateTime createdAt;
}
