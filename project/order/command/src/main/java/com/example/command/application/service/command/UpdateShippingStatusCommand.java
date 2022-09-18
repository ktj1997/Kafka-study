package com.example.command.application.service.command;
import com.example.library.vo.ShippingStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateShippingStatusCommand extends BaseCommand{
  private String orderId;
  private ShippingStatus shippingStatus;
}
