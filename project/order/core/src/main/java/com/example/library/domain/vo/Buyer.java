package com.example.library.domain.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@Embeddable
@AllArgsConstructor
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
