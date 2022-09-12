package com.example.command.application.port.out.rest;

import com.example.command.adapter.out.rest.res.AddressDetailResponse;

public interface ShippingGateway {
  AddressDetailResponse getAddressDetail(Long id);
}
