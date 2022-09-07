package com.example.item.application.port.in;

import com.example.item.application.port.in.command.ReduceStockCommand;
import com.example.item.application.port.in.info.ItemInfo;

public interface ItemUseCase {
  ItemInfo getItemDetail(Long id);

  long reduceStock(ReduceStockCommand command);
}
