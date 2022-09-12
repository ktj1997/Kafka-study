package com.example.shipping.adatper.out.persistence.repository;

import com.example.shipping.domain.entity.Address;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
  List<Address> findAllByUserIdAndDeletedIsFalse(String userId);
}
