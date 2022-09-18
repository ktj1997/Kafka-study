package com.example.shipping.adatper.out.persistence;

import com.example.core.exceptions.EntityNotFoundException;
import com.example.core.exceptions.GlobalErrorCode;
import com.example.shipping.adatper.out.persistence.repository.AddressRepository;
import com.example.shipping.application.port.out.AddressDataAccessor;
import com.example.shipping.domain.entity.Address;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class AddressPersistenceAdapter implements AddressDataAccessor {

  private final AddressRepository addressRepository;

  @Override
  public Address findById(Long id) {
    return addressRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException(GlobalErrorCode.ENTITY_NOT_FOUND));
  }

  @Override
  public List<Address> findAllActiveAddressByUserId(String userId) {
    return addressRepository.findAllByUserIdAndActiveIsTrue(userId);
  }

  @Override
  @Transactional
  public Address save(Address address) {
    return addressRepository.save(address);
  }
}
