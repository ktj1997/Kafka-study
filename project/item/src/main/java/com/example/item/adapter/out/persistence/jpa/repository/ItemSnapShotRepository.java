package com.example.item.adapter.out.persistence.jpa.repository;

import com.example.item.domain.ItemSnapShot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemSnapShotRepository extends JpaRepository<ItemSnapShot, Long> {}
