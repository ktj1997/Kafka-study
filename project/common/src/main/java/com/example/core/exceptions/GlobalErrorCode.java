package com.example.core.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum GlobalErrorCode {
  INTERNAL_SERVER_ERROR("System-001", "Internal Server Error"),
  ENTITY_NOT_FOUND("System-002", "Entity Not Found");
  private final String code;
  private final String message;
}
