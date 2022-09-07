package com.example.item.adapter.out.persistence.redis;

public class ItemRedisValueGenerator {
  public static String generate(String transactionId, String userId, int sequence) {
    return String.format("item_%s_%s_%d", transactionId, userId, sequence);
  }
}
