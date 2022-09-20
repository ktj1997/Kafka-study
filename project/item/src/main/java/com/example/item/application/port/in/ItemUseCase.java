package com.example.item.application.port.in;

import com.example.item.application.port.in.dto.ReduceStockCommandDto;
import com.example.item.application.service.command.ReduceStockCommand;
import com.example.item.application.port.in.dto.ItemInfo;

public interface ItemUseCase {
  ItemInfo getItemDetail(Long id);

  long reduceStock(ReduceStockCommandDto.Request reqDto);
}
