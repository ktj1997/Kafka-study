package com.example.command.application.service.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

  ALREADY_CANCELED("ORDER-001","Order Already Canceled");

  private final String code;
  private final String message;
}
