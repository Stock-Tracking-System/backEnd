package com.project.stockTracking.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.project.stockTracking.entity.WarehouseProduct;

public interface WarehouseProductRepository extends JpaRepository<WarehouseProduct, Long> {
}
