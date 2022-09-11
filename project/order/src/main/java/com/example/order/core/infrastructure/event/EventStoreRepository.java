package com.example.core.events;

import com.example.core.events.EventModel;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventStoreRepository extends MongoRepository<EventModel, String> {
  List<EventModel> findByAggregateIdentifier(String aggregateIdentifier);
}
