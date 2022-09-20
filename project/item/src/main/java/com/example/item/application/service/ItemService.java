package com.example.item.application.service;

import com.example.item.application.port.in.ItemUseCase;
import com.example.item.application.port.in.dto.ReduceStockCommandDto;
import com.example.item.application.service.command.ReduceStockCommand;
import com.example.item.application.port.in.dto.ItemInfo;
import com.example.item.application.port.out.persistence.ItemDataAccessor;
import com.example.item.domain.Item;
import com.example.item.domain.ItemStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ItemService implements ItemUseCase {

  private final ItemDataAccessor itemDataAccessor;

  @Override
  @Transactional
  public ItemInfo getItemDetail(Long id) {
    Item item = itemDataAccessor.getItem(id);
    int orderedItemCount = itemDataAccessor.countOrderedItem(id);
    int remainStock = item.getStock() - orderedItemCount;

    if (remainStock <= 0 && item.getStatus().equals(ItemStatus.ACTIVE))
      item.updateStatus(ItemStatus.SOLD_OUT);

    return new ItemInfo(
        item.getId(), item.getName(), item.getPrice(), remainStock, item.getStatus());
  }

  @Override
  @Transactional
  public long reduceStock(ReduceStockCommandDto.Request reqDto) {
    Item item = itemDataAccessor.getItem(reqDto.getItemId());
    return itemDataAccessor.reduceStock(
        item.getId(),
        reqDto.getTransactionId(),
        reqDto.getUserId(),
        item.getStock(),
        reqDto.getRequestQuantity());
  }
}
