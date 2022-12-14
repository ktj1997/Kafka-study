package com.example.command.adapter.in.mq.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ShippingAddressChangedMessage {
  private String orderId;
  private String postNo;
  private String streetAddress;
  private String addressDetail;
}
