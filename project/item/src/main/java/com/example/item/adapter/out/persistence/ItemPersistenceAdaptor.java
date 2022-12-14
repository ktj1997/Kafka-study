package com.example.item.adapter.out.persistence;

import com.example.core.exceptions.EntityNotFoundException;
import com.example.core.exceptions.GlobalErrorCode;
import com.example.item.adapter.out.persistence.jpa.repository.ItemRepository;
import com.example.item.adapter.out.persistence.redis.StockRedisRepository;
import com.example.item.application.port.out.persistence.ItemDataAccessor;
import com.example.item.domain.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ItemPersistenceAdaptor implements ItemDataAccessor {

  private final ItemRepository itemRepository;
  private final StockRedisRepository stockRedisRepository;

  @Override
  public Item getItem(Long id) {
    return itemRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException(GlobalErrorCode.ENTITY_NOT_FOUND));
  }

  @Override
  public int countOrderedItem(Long id) {
    return stockRedisRepository.countOrderedItem(id);
  }

  @Override
  public long reduceStock(
      Long itemId, String transactionId, String userId, int totalQuantity, int requestQuantity) {
    return stockRedisRepository.reduceItemStock(
        itemId, transactionId, userId, totalQuantity, requestQuantity);
  }
}
