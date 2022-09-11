package com.example.shipping.application.port.out;

import com.example.shipping.domain.entity.Address;

public interface AddressDataAccessor {

  Address save(Address address);
}
