package com.example.query.application.service.query;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FindOrderByIdQuery extends BaseQuery {
  private String orderId;
}
