package com.example.command.adapter.out.persistence.mongo;

import com.example.command.application.port.out.persistence.mongo.EventSourcingHandler;
import com.example.command.domain.aggregate.OrderAggregate;
import com.example.command.domain.aggregate.AggregateRoot;
import com.example.command.application.service.event.EventStore;
import com.example.library.event.object.BaseEvent;
import java.util.Comparator;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderEventPersistenceAdapter implements
    EventSourcingHandler<OrderAggregate> {

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
