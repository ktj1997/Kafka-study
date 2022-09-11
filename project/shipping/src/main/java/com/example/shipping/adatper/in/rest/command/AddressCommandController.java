package com.example.shipping.adatper.in.rest.command;

import com.example.shipping.adatper.in.rest.command.req.RegisterAddressRequest;
import com.example.shipping.application.port.in.command.AddressCommandUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressCommandController {

  private final AddressCommandUseCase commandUseCase;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Long> registerShippingAddress(@RequestBody RegisterAddressRequest request) {
    Long response = commandUseCase.registerShippingAddress(request);
    return new ResponseEntity<Long>(response, HttpStatus.CREATED);
  }
}
