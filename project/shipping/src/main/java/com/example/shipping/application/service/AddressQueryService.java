package com.example.shipping.application.service;

import com.example.core.exceptions.EntityNotFoundException;
import com.example.core.exceptions.GlobalErrorCode;
import com.example.shipping.application.port.in.info.AddressInfo;
import com.example.shipping.application.port.in.query.AddressQueryUseCase;
import com.example.shipping.application.port.out.AddressDataAccessor;
import com.example.shipping.domain.entity.Address;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AddressQueryService implements AddressQueryUseCase {

  private final AddressDataAccessor addressDataAccessor;

  @Override
  public List<AddressInfo> getActiveAddress(String userId) {
    return addressDataAccessor.findAllActiveAddressByUserId(userId).stream()
        .map(
            address ->
                new AddressInfo(
                    address.getPostNo(), address.getStreetAddress(), address.getAddressDetail()))
        .collect(Collectors.toList());
  }

  @Override
  public AddressInfo getAddress(Long id) {
    Address address = addressDataAccessor.findById(id);
    if (address.isDeleted()) throw new EntityNotFoundException(GlobalErrorCode.ENTITY_NOT_FOUND);
    return new AddressInfo(
        address.getPostNo(), address.getStreetAddress(), address.getAddressDetail());
  }
}
