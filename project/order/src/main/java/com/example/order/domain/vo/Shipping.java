package com.example.order.domain.vo;

import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Shipping {
  private String postNo;
  private String streetAddress;
  private String addressDetail;
}
