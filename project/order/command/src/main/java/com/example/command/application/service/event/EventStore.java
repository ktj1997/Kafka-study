package com.example.command.application.service.event;

import com.example.library.event.object.BaseEvent;
import java.util.List;

/**
 * EventStore은 Immutable
 * Save || Get (O)
 * Update || Delete (X)
 */
public interface EventStore {
  void saveEvent(String aggregateId, Iterable<BaseEvent> events, int expectedVersion);

  List<BaseEvent> getEvents(String aggregateId);

  /** -1 --> New Event expectedVersion과 versionOfLastEvent가 다르다는건, 동시성문제가 발생 했다는 것 (누군가가 먼저 처리) */
  default boolean isConcurrencyCollisionOccurred(int expectedVersion, int versionOfLastEvent) {
    return expectedVersion != -1 && versionOfLastEvent != expectedVersion;
  }
}
