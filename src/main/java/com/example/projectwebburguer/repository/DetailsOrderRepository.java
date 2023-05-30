package com.example.projectwebburguer.repository;

import com.example.projectwebburguer.model.DetailsOrderRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailsOrderRepository extends JpaRepository<DetailsOrderRecord, Long> {
}
