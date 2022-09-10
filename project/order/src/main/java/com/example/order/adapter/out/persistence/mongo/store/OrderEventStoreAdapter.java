package com.example.order.adapter.out.persistence.mongo.store;

import com.example.core.events.BaseEvent;
import com.example.core.events.EventModel;
import com.example.core.events.EventProducer;
import com.example.core.exceptions.AggregateNotFoundException;
import com.example.core.exceptions.ConcurrencyException;
import com.example.core.exceptions.GlobalErrorCode;
import com.example.core.events.EventStoreRepository;
import com.example.order.application.port.out.persistence.mongo.OrderEventStore;
import com.example.order.domain.OrderAggregate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@RequiredArgsConstructor
public class OrderEventStoreAdapter implements OrderEventStore {

  private final EventProducer eventProducer;
  private final EventStoreRepository eventStoreRepository;

  @Override
  public void saveEvent(String aggregateId, Iterable<BaseEvent> events, int expectedVersion) {
    List<EventModel> eventStream = eventStoreRepository.findByAggregateIdentifier(aggregateId);
    int versionOfLastEvent =
        eventStream.isEmpty()
            ? expectedVersion
            : eventStream.get(eventStream.size() - 1).getVersion();

    if (isConcurrencyCollisionOccurred(expectedVersion, versionOfLastEvent)) {
      throw new ConcurrencyException(
          GlobalErrorCode.INTERNAL_SERVER_ERROR.getCode(), "Concurrency Exception Occurred");
    }
    int version = expectedVersion;

    for (BaseEvent event : events) {
      version++;
      event.setVersion(version);
      EventModel eventModel =
          EventModel.builder()
              .createdAt(LocalDateTime.now())
              .aggregateIdentifier(aggregateId)
              .aggregateType(OrderAggregate.class.getTypeName())
              .version(version)
              .eventType(event.getClass().getTypeName())
              .eventData(event)
              .build();

      EventModel persistedEvent = eventStoreRepository.save(eventModel);

      if (persistedEvent.getId().isEmpty()) {
        eventProducer.produce(event.getClass().getSimpleName(), event);
      }
    }
  }

  @Override
  public List<BaseEvent> getEvents(String aggregateId) {
    List<EventModel> eventStream = eventStoreRepository.findByAggregateIdentifier(aggregateId);
    if (eventStream == null || eventStream.isEmpty())
      throw new AggregateNotFoundException(
          GlobalErrorCode.INTERNAL_SERVER_ERROR.getCode(), "Aggregate Not Found");
    return eventStream.stream().map(EventModel::getEventData).collect(Collectors.toList());
  }
}
