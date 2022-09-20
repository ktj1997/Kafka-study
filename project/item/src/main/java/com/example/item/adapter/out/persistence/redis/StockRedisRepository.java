package com.example.item.adapter.out.persistence.redis;

import com.example.core.exceptions.ApiException;
import com.example.item.application.service.exception.ErrorCode;
import com.example.item.application.service.exception.OutOfStockException;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class StockRedisRepository {
  private final RedisTemplate<String, String> redisTemplate;

  public int countOrderedItem(Long id) {
    String key = String.valueOf(id);
    SetOperations<String, String> setOperator = redisTemplate.opsForSet();
    Long size = Optional.ofNullable(setOperator.size(key)).orElse(0L);

    return size.intValue();
  }

  @Transactional
  public long reduceItemStock(
      Long itemId, String transactionId, String userId, int totalQuantity, int requestQuantity) {
    int orderedStockCount = countOrderedItem(itemId);
    if (orderedStockCount + requestQuantity > totalQuantity) {
      throw new OutOfStockException(ErrorCode.OUT_OF_STOCK);
    }
    List<Long> txResult =
        redisTemplate.execute(
            new SessionCallback<>() {
              public List<Long> execute(RedisOperations operations) throws DataAccessException {
                String key = String.valueOf(itemId);
                operations.multi();
                SetOperations setOperations = operations.opsForSet();
                for (int sequence = 1; sequence <= requestQuantity; sequence++) {
                  String value = ItemRedisValueGenerator.generate(transactionId, userId, sequence);
                  setOperations.add(key, value);
                }
                return operations.exec();
              }
            });
    return txResult == null ? 0 : txResult.stream().filter(it -> it == 1L).count();
  }
}
