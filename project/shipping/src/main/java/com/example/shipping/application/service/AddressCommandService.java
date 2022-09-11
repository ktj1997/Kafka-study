package com.example.shipping.application.service;

import com.example.shipping.application.port.in.ShippingCommandUseCase;
import com.example.shipping.application.port.in.command.RegisterAddressCommandDto;
import com.example.shipping.application.port.out.AddressDataAccessor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShippingCommandService implements ShippingCommandUseCase {

  private final AddressDataAccessor addressDataAccessor;

  @Override
  public Long registerShippingAddress(RegisterAddressCommandDto commandDto) {
    return null;
  }
}
