package com.example.command.adapter.out.rest.client;

import com.example.order.application.port.out.rest.res.AddressDetailResponse;
import com.example.order.core.config.rest.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "shipping-api", url = "${gateway.shipping}", configuration = FeignConfig.class)
public interface ShippingClient {
  AddressDetailResponse getAddressDetail(Long id);
}
