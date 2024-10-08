package com.project.stockTracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.stockTracking.entity.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
