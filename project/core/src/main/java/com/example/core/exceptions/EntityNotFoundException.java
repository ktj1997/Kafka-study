package com.example.core.exceptions;

import lombok.Getter;

@Getter
public class EntityNotFoundException extends ApiException {

  public EntityNotFoundException(GlobalErrorCode code) {
    super(code.getCode(), code.getMessage());
  }
}
