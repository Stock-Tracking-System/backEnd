package com.project.stockTracking.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.project.stockTracking.entity.StockMovement;

public interface StockMovementRepository extends JpaRepository<StockMovement, Long> {
}
