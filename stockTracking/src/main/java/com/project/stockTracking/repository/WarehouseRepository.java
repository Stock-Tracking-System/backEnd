package com.project.stockTracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.stockTracking.entity.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
}
