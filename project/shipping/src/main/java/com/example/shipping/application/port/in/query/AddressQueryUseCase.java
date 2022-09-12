package com.example.shipping.application.port.in.query;

import com.example.shipping.application.port.in.info.AddressInfo;
import java.util.List;

public interface AddressQueryUseCase {
  List<AddressInfo> getActiveAddress(String userId);

  AddressInfo getAddress(Long id);
}
