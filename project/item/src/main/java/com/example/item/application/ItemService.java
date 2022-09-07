package com.example.item.application;

import com.example.item.application.port.in.ItemUseCase;
import com.example.item.application.port.in.command.ReduceStockCommand;
import com.example.item.application.port.in.info.ItemInfo;
import com.example.item.application.port.out.persistence.ItemDataAccessor;
import com.example.item.domain.Item;
import com.example.item.domain.ItemStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemService implements ItemUseCase {

  private final ItemDataAccessor itemDataAccessor;

  @Override
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
  public long reduceStock(ReduceStockCommand command) {
    return itemDataAccessor.reduceStock(
        command.getItemId(),
        command.getTransactionId(),
        command.getUserId(),
        command.getQuantity());
  }
}
