package com.example.order.application.utils;

import java.util.UUID;

public class TransactionIdGenerator {

  public static String generate() {
    return UUID.randomUUID().toString();
  }
}
