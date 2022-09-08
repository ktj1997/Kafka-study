package com.example.order.adapter.out.persistence.jpa.repository;

import com.example.order.domain.entity.OrderHistory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Long> {
  List<OrderHistory> findAllByOrderIdAndTransactionId(Long orderId, String transactionId);
}
