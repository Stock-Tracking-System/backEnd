package com.project.stockTracking.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.project.stockTracking.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}