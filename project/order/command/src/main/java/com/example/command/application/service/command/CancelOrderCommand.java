package com.example.command.application.service.command;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CancelOrderCommand extends BaseCommand {
  private String reason;
  private LocalDateTime canceledAt;
}
