package com.example.command.adapter.out.persistence.mongo.repository;

import com.example.command.adapter.out.persistence.mongo.document.EventModel;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventStoreRepository extends MongoRepository<EventModel, String> {
  List<EventModel> findByAggregateIdentifier(String aggregateIdentifier);
}
