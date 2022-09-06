package com.example.item.config.exceptions;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class ErrorResponse {
  private String code;

  private String message;
  private LocalDateTime timeStamp;

  public ErrorResponse(String code, String message) {
    this.code = code;
    this.message = message;
    this.timeStamp = LocalDateTime.now();
  }
}
