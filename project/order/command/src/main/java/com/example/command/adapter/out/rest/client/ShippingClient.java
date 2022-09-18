package com.example.command.adapter.out.rest.client;

import com.example.command.adapter.out.rest.res.AddressDetailResponse;
import com.example.config.rest.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "shipping-api", url = "${gateway.shipping}", configuration = FeignConfig.class)
public interface ShippingClient {
  @GetMapping(ShippingClientConstant.ADDRESS_DETAIL)
  AddressDetailResponse getAddressDetail(@PathVariable  Long addressId);
}
