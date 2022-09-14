package com.example.query.application.service.query.handler;

import com.example.core.domain.BaseEntity;
import com.example.query.application.port.out.persistence.OrderDataAccessor;
import com.example.query.application.service.query.FindOrderByIdQuery;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderQueryHandler implements QueryHandler{

  private final OrderDataAccessor dataAccessor;
  @Override
  public List<BaseEntity> handle(FindOrderByIdQuery query) {
    String orderId = query.getOrderId();
    return List.of(dataAccessor.findById(orderId));
  }
}
