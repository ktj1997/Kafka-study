package com.example.order.adapter.out.persistence.mongo.document;

import com.example.core.events.BaseEvent;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Builder
@Document(collection = "eventStore")
public class EventModel {

  @Id private String id;
  private int version;

  private String aggregateType;
  private String aggregateIdentifier;

  private String eventType;
  private BaseEvent eventData;

  private LocalDateTime createdAt;
}
