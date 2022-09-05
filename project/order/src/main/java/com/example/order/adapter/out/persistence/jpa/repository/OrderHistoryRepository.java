package com.example.order.adapter.out.persistence.jpa.repository;

import com.example.order.domain.OrderHistory;
import com.example.order.domain.OrderHistoryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderHistoryRepository extends JpaRepository<OrderHistory, OrderHistoryId> {}
