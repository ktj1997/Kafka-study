package com.example.command.application.service.command;


import com.example.library.vo.Buyer;
import com.example.library.vo.Item;
import com.example.library.vo.Shipping;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
