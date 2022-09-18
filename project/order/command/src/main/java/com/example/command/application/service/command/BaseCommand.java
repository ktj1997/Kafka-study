package com.example.command.application.service.command;

import com.example.core.messages.Message;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public abstract class BaseCommand extends Message {
  public BaseCommand(String id) {
    super(id);
  }
}
