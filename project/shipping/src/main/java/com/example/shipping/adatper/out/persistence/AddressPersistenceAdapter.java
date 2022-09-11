package com.example.shipping.adatper.out.persistence;

import com.example.shipping.adatper.out.persistence.repository.AddressRepository;
import com.example.shipping.application.port.out.AddressDataAccessor;
import com.example.shipping.domain.entity.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class AddressPersistenceAdapter implements AddressDataAccessor {

  private final AddressRepository addressRepository;

  @Override
  @Transactional
  public Address save(Address address) {
    return addressRepository.save(address);
  }
}
