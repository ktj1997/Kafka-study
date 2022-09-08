package com.example.order.domain.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = {"id", "name", "phoneNumber"})
public class Buyer {

  @Column(name = "buyer_id")
  private String id;

  @Column(name = "buyer_name")
  private String name;

  @Column(name = "buyer_phone_number")
  private String phoneNumber;
}
