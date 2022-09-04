package com.example.order.adapter.out.persistence.jpa.repository;

import com.example.kafka.project.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
