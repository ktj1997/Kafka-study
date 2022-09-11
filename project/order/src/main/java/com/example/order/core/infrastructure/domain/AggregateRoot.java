package com.example.core.domain;

import com.example.core.events.BaseEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AggregateRoot {

  @Getter protected String id;
  @Getter @Setter private int version = -1;

  private final List<BaseEvent> changes = new ArrayList<>();

  public List<BaseEvent> getUnCommittedChanges() {
    return this.changes;
  }

  public void markChangesAsCommitted() {
    this.changes.clear();
  }

  protected void applyChange(BaseEvent event, Boolean isNewEvent) {
    try {
      Method method = getClass().getMethod("apply", event.getClass());
      method.setAccessible(true);
      method.invoke(this, event);
    } catch (NoSuchMethodException ex) {
      log.info(
          "The apply method was not founded in the aggregate for {}", event.getClass().getName());
    } catch (IllegalAccessException | InvocationTargetException ex) {
      log.error("Error applying event to aggregate");
    } finally {
      if (isNewEvent) {
        changes.add(event);
      }
    }
  }

  public void raiseEvent(BaseEvent event) {
    applyChange(event, true);
  }

  public void replayEvent(Iterable<BaseEvent> events) {
    events.forEach(event -> applyChange(event, false));
  }
}
