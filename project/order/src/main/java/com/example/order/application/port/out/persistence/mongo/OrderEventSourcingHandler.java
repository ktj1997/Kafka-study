package com.example.order.application.port.out.persistence.mongo;

import com.example.core.events.EventSourcingHandler;
import com.example.order.domain.OrderAggregate;

public interface OrderEventSourcingHandler extends EventSourcingHandler<OrderAggregate> {

}
