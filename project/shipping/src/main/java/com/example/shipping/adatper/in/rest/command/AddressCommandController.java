package com.example.shipping.adatper.in.rest;

import com.example.shipping.adatper.in.rest.req.RegisterAddressRequest;
import com.example.shipping.application.port.in.ShippingCommandUseCase;
import com.example.shipping.application.port.in.command.RegisterAddressCommandDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shipping")
@RequiredArgsConstructor
public class ShippingCommandController {

  private final ShippingCommandUseCase commandUseCase;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Long> registerShippingAddress(@RequestBody RegisterAddressRequest request) {
    RegisterAddressCommandDto commandDto = request.toCommandDto();
    Long response = commandUseCase.registerShippingAddress(commandDto);
    return new ResponseEntity<Long>(response, HttpStatus.CREATED);
  }
}
