package com.example.query.application.service.info;

import com.example.library.domain.vo.Buyer;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BuyerInfo {
  private String id;

  private String name;

  private String phoneNumber;

  public BuyerInfo(Buyer buyer) {
    this.id = buyer.getId();
    this.name = buyer.getName();
    this.phoneNumber = buyer.getPhoneNumber();
  }
}
