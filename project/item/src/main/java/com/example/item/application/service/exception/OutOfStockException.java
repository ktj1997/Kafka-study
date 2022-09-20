package com.example.item.application.service.exception;

import com.example.core.exceptions.ApiException;
import com.example.core.exceptions.GlobalErrorCode;

public class OutOfStockException extends ApiException {
  public OutOfStockException(ErrorCode code) {
    super(code.getCode(), code.getMessage());
  }

  public OutOfStockException(String code, String message) {
    super(code, message);
  }
}
