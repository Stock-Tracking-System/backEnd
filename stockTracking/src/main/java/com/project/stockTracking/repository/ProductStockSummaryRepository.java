package com.project.stockTracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.stockTracking.entity.ProductStockSummary;

public interface ProductStockSummaryRepository extends JpaRepository<ProductStockSummary, Long> {
}
