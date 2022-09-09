package com.example.core.commands;

import com.example.core.messages.Message;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseCommand extends Message {
  public BaseCommand(String id) {
    super(id);
  }
}
