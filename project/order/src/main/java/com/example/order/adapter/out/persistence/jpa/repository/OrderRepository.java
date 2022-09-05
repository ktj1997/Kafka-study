package com.example.order.adapter.out.persistence.jpa.repository;

import com.example.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
