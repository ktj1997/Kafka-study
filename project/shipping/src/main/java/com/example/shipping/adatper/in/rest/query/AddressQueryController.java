package com.example.shipping.adatper.in.rest.query;

import com.example.shipping.application.port.in.info.AddressInfo;
import com.example.shipping.application.port.in.query.AddressQueryUseCase;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressQueryController {
  private final AddressQueryUseCase addressQueryUseCase;

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<AddressInfo> getAddressById(@PathVariable Long id) {
    AddressInfo address = addressQueryUseCase.getAddress(id);

    return ResponseEntity.ok(address);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<List<AddressInfo>> getAllAddressByUser(@RequestParam String userId) {

    List<AddressInfo> addresses = addressQueryUseCase.getActiveAddress(userId);
    return ResponseEntity.ok(addresses);
  }
}
