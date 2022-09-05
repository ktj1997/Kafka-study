package com.example.order.application.port.in.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderCommand {
  private String userId;
  private String userName;
  private String address;
  private String phoneNumber;
}
