package com.example.core.exceptions;

public class AggregateNotFoundException extends ApiException {

  public AggregateNotFoundException(GlobalErrorCode globalErrorCode) {
    super(globalErrorCode.getCode(), globalErrorCode.getMessage());
  }

  public AggregateNotFoundException(String code, String message) {
    super(code, message);
  }
}
