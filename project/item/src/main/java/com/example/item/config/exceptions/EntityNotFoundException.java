package com.example.item.config.exceptions;

import lombok.Getter;

@Getter
public class EntityNotFoundException extends ApiException {

  public EntityNotFoundException(ErrorCode code) {
    super(code.getCode(), code.getMessage());
  }
}
