package com.example.command.application.port.out.mq;

import com.example.query.domain.vo.Shipping;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ShippingAddressChangedEvent {
  private String orderId;
  private Shipping shipping;
}
