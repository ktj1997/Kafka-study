package com.example.query.application.port.in.info;

import com.example.library.domain.vo.Buyer;
import com.example.library.domain.vo.CancelInfo;
import com.example.library.domain.vo.Item;
import com.example.library.domain.vo.OrderStatus;
import com.example.library.domain.vo.Shipping;
import com.example.library.domain.vo.ShippingStatus;
import com.example.query.domain.entity.Order;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import lombok.Getter;

@Getter
public class OrderInfo {
  private OrderStatus orderStatus;
  private ShippingStatus shippingStatus;
  private Buyer buyer;
  private Item item;
  private Shipping shipping;
  private CancelInfo cancelInfo;
  private int totalPrice;

  private LocalDateTime createdAt;

  public OrderInfo(Order order) {
    this.orderStatus = order.getOrderStatus();
    this.shippingStatus = order.getShippingStatus();
    this.buyer = order.getBuyer();
    this.item = order.getItem();
    this.shipping = order.getShipping();
    this.cancelInfo = order.getCancelInfo();
    this.totalPrice = order.getTotalPrice();
    this.createdAt = order.getCreatedAt();
  }
}
