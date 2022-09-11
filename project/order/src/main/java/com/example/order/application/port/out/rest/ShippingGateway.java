package com.example.order.application.port.out.rest;

import com.example.order.application.port.out.rest.res.AddressDetailResponse;

public interface ShippingGateway {
  AddressDetailResponse getAddressDetail(Long id);
}
