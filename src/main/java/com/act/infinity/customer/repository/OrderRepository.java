package com.act.infinity.customer.repository;

import com.act.infinity.customer.entity.OrderEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
  Optional<List<OrderEntity>> findOrderEntitiesByCustomerId(Integer customerId);
}
