package com.example.order.application.service;

import com.example.order.adapter.in.rest.command.req.CreateOrderCommandRequest;
import com.example.order.application.port.out.rest.ItemGateway;
import com.example.order.application.port.out.rest.ShippingGateway;
import com.example.order.application.port.out.rest.res.AddressDetailResponse;
import com.example.order.application.port.out.rest.res.ItemDetailResponse;
import com.example.order.application.service.command.CreateOrderCommand;
import com.example.order.core.infrastructure.command.CommandDispatcher;
import com.example.core.exceptions.ApiException;
import com.example.core.exceptions.GlobalErrorCode;
import com.example.order.application.port.in.OrderCommandUseCase;
import com.example.order.domain.vo.Buyer;
import com.example.order.domain.vo.Item;
import com.example.order.domain.vo.Shipping;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderCommandService implements OrderCommandUseCase {

  private final CommandDispatcher dispatcher;
  private final ItemGateway itemGateway;
  private final ShippingGateway shippingGateway;

  @Override
  @Transactional
  public String createOrder(CreateOrderCommandRequest req) {
    String id = UUID.randomUUID().toString();
    try {
      Buyer buyer =
          Buyer.builder()
              .id(req.getUserId())
              .name(req.getUserName())
              .phoneNumber(req.getPhoneNumber())
              .build();

      ItemDetailResponse itemDetail = itemGateway.getItemDetail(req.getItemId());
      Item item =
          Item.builder()
              .itemId(itemDetail.getItemId())
              .itemName(itemDetail.getItemName())
              .quantity(req.getQuantity())
              .build();

      AddressDetailResponse addressDetail = shippingGateway.getAddressDetail(req.getShippingId());
      Shipping shipping =
          Shipping.builder()
              .postNo(addressDetail.getPostNo())
              .streetAddress(addressDetail.getStreetAddress())
              .addressDetail(addressDetail.getAddressDetail())
              .build();

      CreateOrderCommand command =
          CreateOrderCommand.builder()
              .item(item)
              .buyer(buyer)
              .shipping(shipping)
              .createdAt(LocalDateTime.now())
              .build();

      command.setId(id);
      dispatcher.send(command);

      return id;

    } catch (Throwable throwable) {
      throwable.printStackTrace();
      throw new ApiException(
          GlobalErrorCode.INTERNAL_SERVER_ERROR.getCode(), "Error while processing Create Order");
    }
  }
}
