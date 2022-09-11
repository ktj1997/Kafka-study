package com.example.shipping.adatper.in.rest.command.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterAddressRequest {
  private String postNo;
  private String streetAddress;
  private String addressDetail;
}
