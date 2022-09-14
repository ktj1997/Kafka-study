package com.example.query.application.service.info;

import com.example.library.domain.vo.Shipping;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ShippingInfo {
  private String postNo;
  private String streetAddress;
  private String addressDetail;

  public ShippingInfo(Shipping shipping) {
    this.postNo = shipping.getPostNo();
    this.streetAddress = shipping.getStreetAddress();
    this.addressDetail = shipping.getAddressDetail();
  }
}
