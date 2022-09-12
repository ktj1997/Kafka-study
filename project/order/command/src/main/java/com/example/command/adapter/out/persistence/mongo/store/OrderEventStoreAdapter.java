package com.example.command.adapter.out.persistence.mongo.store;

import com.example.command.adapter.out.persistence.mongo.document.EventModel;
import com.example.command.domain.aggregate.OrderAggregate;
import com.example.library.event.object.BaseEvent;
import com.example.library.event.producer.EventProducer;
import com.example.core.exceptions.AggregateNotFoundException;
import com.example.core.exceptions.ConcurrencyException;
import com.example.core.exceptions.GlobalErrorCode;
import com.example.command.application.service.event.EventStore;
import com.example.command.adapter.out.persistence.mongo.repository.EventStoreRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderEventStoreAdapter implements EventStore {

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

      if (!persistedEvent.getId().isEmpty()) {
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
