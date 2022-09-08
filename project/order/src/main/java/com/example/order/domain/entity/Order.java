package com.example.order.domain.entity;

import com.example.order.adapter.out.persistence.jpa.entity.BaseTimeEntity;
import com.example.order.domain.OrderStatus;
import com.example.order.domain.vo.Buyer;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "transaction_id", nullable = false)
  private String transactionId;

  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private OrderStatus status;

  @Embedded private Buyer buyer;

  @Column(name = "address", length = 50)
  private String address;
}
