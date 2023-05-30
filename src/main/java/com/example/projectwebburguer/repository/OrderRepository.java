package com.example.projectwebburguer.repository;

import com.example.projectwebburguer.model.OrderRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderRecord, Long>{
}
