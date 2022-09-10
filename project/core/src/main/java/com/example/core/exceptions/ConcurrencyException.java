package com.example.core.exceptions;

public class ConcurrencyException extends ApiException {
  public ConcurrencyException(GlobalErrorCode code) {
    super(code.getCode(), code.getMessage());
  }

  public ConcurrencyException(String code, String message) {
    super(code, message);
  }
}
