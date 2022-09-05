package com.example.order.domain;

import com.example.order.adapter.out.persistence.jpa.entity.BaseTimeEntity;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderHistory extends BaseTimeEntity {

  @EmbeddedId private OrderHistoryId id;

  @Column
  @Enumerated(EnumType.STRING)
  private OrderStatus status;
}
