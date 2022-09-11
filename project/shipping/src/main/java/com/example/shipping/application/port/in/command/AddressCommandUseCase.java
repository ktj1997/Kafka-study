package com.example.shipping.application.port.in;

import com.example.shipping.application.port.in.command.RegisterAddressCommandDto;

public interface AddressCommandUseCase {
  Long registerShippingAddress(RegisterAddressCommandDto commandDto);
}
