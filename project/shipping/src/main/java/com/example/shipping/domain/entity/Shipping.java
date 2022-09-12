package com.example.shipping.domain.entity;

import com.example.core.domain.BaseEntity;
import com.example.shipping.domain.vo.ShippingStatus;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "shipping")
@NoArgsConstructor
public class Shipping extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "order_id")
  private String orderId;

  @Column(name = "address_id")
  private Long addressId;

  @Enumerated
  @Column(name = "shipping_status")
  private ShippingStatus shippingStatus;

  @Column(name = "sequence")
  private int sequence;

  public Shipping(String orderId, Long addressId, ShippingStatus shippingStatus) {
    this.id = null;
    this.orderId = orderId;
    this.addressId = addressId;
    this.shippingStatus = shippingStatus;
    this.sequence = this.shippingStatus.getSequence();
  }
}
