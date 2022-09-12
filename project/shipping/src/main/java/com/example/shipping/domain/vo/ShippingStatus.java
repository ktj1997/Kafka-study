package com.example.shipping.domain.vo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ShippingStatus {
  SHIPPING_PREPARE(1),
  SHIPPING_START(2),
  SHIPPING_COMPLETE(3);

  private final int sequence;
}
