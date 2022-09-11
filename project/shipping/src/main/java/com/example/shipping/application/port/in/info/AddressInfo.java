package com.example.shipping.application.port.in.info;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AddressInfo {
  private String postNo;
  private String streetAddress;
  private String addressDetail;
}
