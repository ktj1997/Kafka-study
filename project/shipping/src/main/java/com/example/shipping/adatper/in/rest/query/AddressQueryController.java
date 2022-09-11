package com.example.shipping.adatper.in.rest.query;

import com.example.shipping.application.port.in.info.AddressInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressQueryController {

  @GetMapping("/{id}")
  public AddressInfo getAddress(@PathVariable Long id) {
    return null;
  }
}
