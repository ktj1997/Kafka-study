package com.example.command.application.service.exception;

import com.example.core.exceptions.ApiException;
import lombok.Getter;

@Getter
public class AlreadyCanceledException extends ApiException {
  public AlreadyCanceledException(String code, String message) {
    super(code, message);
  }

  public AlreadyCanceledException(ErrorCode code) {
    super(code.getCode(), code.getMessage());
  }
}
