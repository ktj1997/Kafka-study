package com.example.command.adapter.out.rest;

import com.example.command.adapter.out.rest.client.ShippingClient;
import com.example.command.adapter.out.rest.res.AddressDetailResponse;
import com.example.command.application.port.out.rest.ShippingGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ShippingGatewayImpl implements ShippingGateway {

  private final ShippingClient shippingClient;

  @Override
  public AddressDetailResponse getAddressDetail(Long id) {
    return shippingClient.getAddressDetail(id);
  }
}
