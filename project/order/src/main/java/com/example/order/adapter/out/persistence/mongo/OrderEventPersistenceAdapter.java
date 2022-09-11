package com.example.order.adapter.out.persistence.mongo;

import com.example.order.core.infrastructure.domain.AggregateRoot;
import com.example.core.events.BaseEvent;
import com.example.order.application.port.out.persistence.mongo.OrderEventSourcingHandler;
import com.example.order.core.infrastructure.event.EventStore;
import com.example.order.domain.OrderAggregate;
import java.util.Comparator;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderEventPersistenceAdapter implements OrderEventSourcingHandler {

  private final EventStore eventStore;

  @Override
  public void save(AggregateRoot aggregate) {
    eventStore.saveEvent(
        aggregate.getId(), aggregate.getUnCommittedChanges(), aggregate.getVersion());
    aggregate.markChangesAsCommitted();
  }

  @Override
  public OrderAggregate getById(String id) {
    OrderAggregate aggregate = new OrderAggregate();
    List<BaseEvent> events = eventStore.getEvents(id);

    if (events != null && !events.isEmpty()) {
      aggregate.replayEvent(events);
      int latestVersion =
          events.stream().map(BaseEvent::getVersion).max(Comparator.naturalOrder()).get();
      aggregate.setVersion(latestVersion);
    }
    return aggregate;
  }
}
