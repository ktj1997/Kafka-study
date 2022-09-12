package com.example.shipping.application.port.out;

import com.example.shipping.domain.entity.Address;
import java.util.List;

public interface AddressDataAccessor {

  Address findById(Long id);

  List<Address> findAllActiveAddressByUserId(String userId);

  Address save(Address address);
}
