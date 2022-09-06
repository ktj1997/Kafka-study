package com.example.item.config.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
  INTERNAL_SERVER_ERROR("500");
  private final String code;
}
