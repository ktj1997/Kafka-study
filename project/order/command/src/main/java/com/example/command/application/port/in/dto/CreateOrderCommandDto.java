package com.example.command.application.port.in.dto;

import com.example.command.adapter.in.rest.req.CreateOrderCommandRequest;
import com.example.library.vo.Buyer;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class CreateOrderCommandDto {

  @Getter
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  public static class Request {
    private Buyer buyer;

    private Long itemId;
    private int quantity;

    private Long shippingId;

    public Request(CreateOrderCommandRequest req) {
      this.buyer = new Buyer(req.getUserId(), req.getUserName(), req.getPhoneNumber());
      this.itemId = req.getItemId();
      this.quantity = req.getQuantity();
      this.shippingId = req.getShippingId();
    }
  }

  @Getter
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  public static class Response {
    String orderId;

    public Response(String orderId){
      this.orderId = orderId;
    }
  }
}
