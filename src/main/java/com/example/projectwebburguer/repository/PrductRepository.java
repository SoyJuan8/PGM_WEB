package com.example.projectwebburguer.repository;

import com.example.projectwebburguer.model.ProductRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrductRepository extends JpaRepository<ProductRecord, Long> {

    List<ProductRecord> findAllByCategoryIs(String category);

    List<ProductRecord> findAllByCarIsTrue();

}
