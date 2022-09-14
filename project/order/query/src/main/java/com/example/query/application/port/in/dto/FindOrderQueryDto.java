package com.example.query.application.port.in.dto;

import com.example.query.application.service.info.BuyerInfo;
import com.example.query.application.service.info.ItemInfo;
import com.example.query.application.service.info.OrderInfo;
import com.example.query.application.service.info.ShippingInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class FindOrderQueryDto {
  @Getter
  @NoArgsConstructor
  public static class ByIdRequest {
    private String id;

    public ByIdRequest(String id) {
      this.id = id;
    }
  }

  @Getter
  @NoArgsConstructor
  public static class Response {
    private BuyerInfo buyer;
    private ShippingInfo shippingInfo;
    private OrderInfo order;
    private ItemInfo item;

    public Response(BuyerInfo buyer, ShippingInfo shipping, OrderInfo order, ItemInfo item) {
      this.buyer = buyer;
      this.shippingInfo = shipping;
      this.order = order;
      this.item = item;
    }
  }
}
