package com.example.shipping.application.service;

import com.example.shipping.adatper.in.rest.command.req.RegisterAddressRequest;
import com.example.shipping.application.port.in.command.AddressCommandUseCase;
import com.example.shipping.application.port.out.AddressDataAccessor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressCommandService implements AddressCommandUseCase {

  private final AddressDataAccessor addressDataAccessor;

  @Override
  public Long registerShippingAddress(RegisterAddressRequest req) {
    return null;
  }
}
