package com.example.core.exceptions;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {
  private String code;
  private String message;
  private LocalDateTime timeStamp;

  public ApiException(String code, String message) {
    this.code = code;
    this.message = message;
    this.timeStamp = LocalDateTime.now();
  }
}
