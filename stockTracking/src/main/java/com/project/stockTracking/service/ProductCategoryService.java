package com.project.stockTracking.service;

import com.project.stockTracking.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.stockTracking.entity.ProductCategory;
import com.project.stockTracking.repository.ProductCategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    public List<ProductCategory> getAllProductCategories() {
        return productCategoryRepository.findAll();
    }

    public Optional<ProductCategory> getProductCategoryById(Long id) {
        return productCategoryRepository.findById(id);
    }

    public ProductCategory createProductCategory(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }

    public ProductCategory updateProductCategory(Long id, ProductCategory productCategoryDetails) {
        ProductCategory productCategory = productCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ProductCategory not found"));

        productCategory.setCategoryName(productCategoryDetails.getCategoryName());
        productCategory.setDescription(productCategoryDetails.getDescription());
        productCategory.setCreatedDate(productCategoryDetails.getCreatedDate());
        productCategory.setCreatedBy(productCategoryDetails.getCreatedBy());
        productCategory.setUpdatedDate(productCategoryDetails.getUpdatedDate());
        productCategory.setUpdatedBy(productCategoryDetails.getUpdatedBy());
        productCategory.setIsDeleted(productCategoryDetails.getIsDeleted());

        return productCategoryRepository.save(productCategory);
    }

    public void deleteProductCategory(Long id) {
        ProductCategory productCategory = productCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ProductCategory not found"));
        productCategoryRepository.delete(productCategory);
    }
}