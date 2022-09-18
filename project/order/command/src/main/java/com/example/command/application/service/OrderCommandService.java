package com.example.command.application.service;

import com.example.command.application.port.in.dto.CreateOrderCommandDto;
import com.example.command.application.service.command.dispatcher.CommandDispatcher;
import com.example.command.application.service.command.CreateOrderCommand;
import com.example.command.application.port.in.OrderCommandUseCase;
import com.example.command.application.port.out.rest.ItemGateway;
import com.example.command.application.port.out.rest.ShippingGateway;
import com.example.command.adapter.out.rest.res.AddressDetailResponse;
import com.example.command.adapter.out.rest.res.ItemDetailResponse;

import com.example.core.exceptions.ApiException;
import com.example.core.exceptions.GlobalErrorCode;
import com.example.library.vo.Buyer;
import com.example.library.vo.Item;
import com.example.library.vo.Shipping;
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
  public CreateOrderCommandDto.Response createOrder(CreateOrderCommandDto.Request dto) {
    String id = UUID.randomUUID().toString();
    try {
      Buyer buyer = dto.getBuyer();
      ItemDetailResponse itemDetail = itemGateway.getItemDetail(dto.getItemId());
      Item item =
          Item.builder()
              .itemId(itemDetail.getItemId())
              .itemName(itemDetail.getItemName())
              .quantity(dto.getQuantity())
              .build();

      AddressDetailResponse addressDetail = shippingGateway.getAddressDetail(dto.getShippingId());
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

      return new CreateOrderCommandDto.Response(id);

    } catch (Throwable throwable) {
      throwable.printStackTrace();
      throw new ApiException(
          GlobalErrorCode.INTERNAL_SERVER_ERROR.getCode(), "Error while processing Create Order");
    }
  }
}
