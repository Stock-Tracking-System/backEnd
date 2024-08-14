package com.project.stockTracking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.stockTracking.entity.ProductStockSummary;
import com.project.stockTracking.exception.ResourceNotFoundException;
import com.project.stockTracking.repository.ProductStockSummaryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductStockSummaryService {

    @Autowired
    private ProductStockSummaryRepository productStockSummaryRepository;

    public List<ProductStockSummary> getAllProductStockSummaries() {
        return productStockSummaryRepository.findAll();
    }

    public Optional<ProductStockSummary> getProductStockSummaryById(Long id) {
        return productStockSummaryRepository.findById(id);
    }

    public ProductStockSummary createProductStockSummary(ProductStockSummary productStockSummary) {
        return productStockSummaryRepository.save(productStockSummary);
    }

    public ProductStockSummary updateProductStockSummary(Long id, ProductStockSummary productStockSummaryDetails) {
        ProductStockSummary productStockSummary = productStockSummaryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ProductStockSummary not found with id: " + id));

        productStockSummary.setProduct(productStockSummaryDetails.getProduct());
        productStockSummary.setTotalAmount(productStockSummaryDetails.getTotalAmount());
        productStockSummary.setUpdatedDate(productStockSummaryDetails.getUpdatedDate());


        return productStockSummaryRepository.save(productStockSummary);
    }

    public void deleteProductStockSummary(Long id) {
        ProductStockSummary productStockSummary = productStockSummaryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ProductStockSummary not found with id: " + id));
        productStockSummaryRepository.delete(productStockSummary);
    }
}

