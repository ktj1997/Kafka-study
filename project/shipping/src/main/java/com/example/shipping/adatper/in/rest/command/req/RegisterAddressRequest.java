package com.example.shipping.adatper.in.rest.req;

import com.example.shipping.application.port.in.command.RegisterAddressCommandDto;
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

  public RegisterAddressCommandDto toCommandDto() {
    return new RegisterAddressCommandDto(postNo, streetAddress, addressDetail);
  }
}
