package com.example.command.application.port.out.mq;

import com.example.library.domain.vo.ShippingStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ShippingStatusChangedEvent {
  String orderId;
  ShippingStatus shippingStatus;
}
