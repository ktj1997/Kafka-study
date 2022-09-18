package com.example.library.event.object;

import com.example.library.vo.Shipping;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ShippingAddressChangedEvent extends BaseEvent {
  private String orderId;
  private Shipping shipping;
}
