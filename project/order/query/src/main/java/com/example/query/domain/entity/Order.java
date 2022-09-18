package com.example.query.domain.entity;

import com.example.core.domain.BaseEntity;
import com.example.library.vo.Buyer;
import com.example.library.vo.CancelInfo;
import com.example.library.vo.Item;
import com.example.library.vo.OrderStatus;
import com.example.library.vo.Shipping;
import com.example.library.vo.ShippingStatus;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order extends BaseEntity {

  @Id private String id;

  @Column(name = "order_status")
  @Enumerated(EnumType.STRING)
  private OrderStatus orderStatus;

  @Column
  @Enumerated(EnumType.STRING)
  private ShippingStatus shippingStatus;

  @Embedded private Buyer buyer;
  @Embedded private Item item;
  @Embedded private Shipping shipping;
  @Embedded private CancelInfo cancelInfo;

  @Column private int totalPrice;

  public void cancel(String reason) {
    this.orderStatus = OrderStatus.CANCELED;
    this.cancelInfo = new CancelInfo(reason, LocalDateTime.now());
  }

  public void updateShippingAddress(Shipping shipping) {
    this.shipping = shipping;
  }

  public void updateShippingStatus(ShippingStatus shippingStatus) {
    this.shippingStatus = shippingStatus;
  }
}
