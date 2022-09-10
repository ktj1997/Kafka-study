package com.example.order.application.port.in.command;

import com.example.core.commands.BaseCommand;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CancelOrderCommand extends BaseCommand {
  private String reason;
  private LocalDateTime canceledAt;
}
