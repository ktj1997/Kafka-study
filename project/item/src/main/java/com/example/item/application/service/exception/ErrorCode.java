package com.example.item.application.service.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
  OUT_OF_STOCK("item-001", "Item's remain Stock is not enough");

  private final String code;
  private final String message;
}
