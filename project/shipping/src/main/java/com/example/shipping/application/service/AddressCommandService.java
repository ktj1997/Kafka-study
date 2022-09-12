package com.example.shipping.application.service;

import com.example.shipping.adatper.in.rest.command.req.RegisterAddressRequest;
import com.example.shipping.application.port.in.command.AddressCommandUseCase;
import com.example.shipping.application.port.out.AddressDataAccessor;
import com.example.shipping.domain.entity.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AddressCommandService implements AddressCommandUseCase {

  private final AddressDataAccessor addressDataAccessor;

  @Override
  @Transactional
  public Long registerShippingAddress(RegisterAddressRequest req) {
    Address address =
        addressDataAccessor.save(
            new Address(
                null,
                req.getUserId(),
                req.getPostNo(),
                req.getStreetAddress(),
                req.getAddressDetail(),
                false));
    return address.getId();
  }

  @Override
  @Transactional
  public void deleteShippingAddress(Long id) {
    Address address = addressDataAccessor.findById(id);
    address.delete();
  }
}
