package com.example.order.domain.entity;

import com.example.core.domain.BaseEntity;
import com.example.order.domain.vo.CancelInfo;
import com.example.order.domain.vo.Item;
import com.example.order.domain.vo.OrderStatus;
import com.example.order.domain.vo.Buyer;
import com.example.order.domain.vo.Shipping;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Embeddable;
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

  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private OrderStatus status;

  @Embedded private Buyer buyer;
  @Embedded private Item item;
  @Embedded private Shipping shipping;
  @Embedded private CancelInfo cancelInfo;

  @Column private int totalPrice;

  public void cancel(String reason) {
    this.status = OrderStatus.CANCELED;
    this.cancelInfo = new CancelInfo(reason, LocalDateTime.now());
  }
}
