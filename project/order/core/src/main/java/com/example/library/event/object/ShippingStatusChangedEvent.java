package com.example.library.event.object;

import com.example.library.domain.vo.ShippingStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ShippingStatusChangedEvent extends BaseEvent {
  String orderId;
  ShippingStatus shippingStatus;
}
