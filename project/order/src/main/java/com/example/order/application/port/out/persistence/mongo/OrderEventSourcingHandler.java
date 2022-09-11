package com.example.order.application.port.out.persistence.mongo;

import com.example.order.core.infrastructure.event.EventSourcingHandler;
import com.example.order.domain.OrderAggregate;

public interface OrderEventSourcingHandler extends EventSourcingHandler<OrderAggregate> {

}
