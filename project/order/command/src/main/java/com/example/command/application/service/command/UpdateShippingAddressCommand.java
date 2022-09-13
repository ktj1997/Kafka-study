package com.example.command.application.service.command;

import com.example.library.domain.vo.Shipping;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateShippingAddressCommand extends BaseCommand{
  private String orderId;
  private Shipping shipping;

}
