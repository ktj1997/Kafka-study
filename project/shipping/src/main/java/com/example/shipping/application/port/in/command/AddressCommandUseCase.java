package com.example.shipping.application.port.in.command;

import com.example.shipping.adatper.in.rest.command.req.RegisterAddressRequest;

public interface AddressCommandUseCase {
  Long registerShippingAddress(RegisterAddressRequest commandDto);

  void deleteShippingAddress(Long id);
}
