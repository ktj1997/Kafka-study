package com.example.order.application.port.out.rest.res;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AddressDetailResponse {
  private String postNo;
  private String streetAddress;
  private String addressDetail;
}
