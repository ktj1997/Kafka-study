package com.example.order.domain;

import com.example.order.adapter.out.persistence.jpa.entity.BaseTimeEntity;
import javax.persistence.Column;
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

  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private OrderStatus status;

  @Column(name = "user_id", length = 50)
  private String userId;

  @Column(name = "user_name", length = 50)
  private String userName;

  @Column(name = "address", length = 50)
  private String address;

  @Column(name = "phone_number", length = 20)
  private String phoneNumber;

  @Column(name = "transaction_id", nullable = false)
  private String transactionId;
}
