package com.example.item.application.port.out.persistence;

import com.example.item.domain.Item;

public interface ItemDataAccessor {
  Item getItem(Long id);

  int countOrderedItem(Long id);

  long reduceStock(Long itemId, String transactionId, String userId, int quantity);
}
