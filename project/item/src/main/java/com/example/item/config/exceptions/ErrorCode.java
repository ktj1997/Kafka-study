package com.example.item.config.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
  ENTITY_NOT_FOUND("404", "Entity Not Found"),
  INTERNAL_SERVER_ERROR("500", "Internal Server Error");
  private final String code;
  private final String message;
}
