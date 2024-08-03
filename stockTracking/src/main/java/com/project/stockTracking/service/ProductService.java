package com.project.stockTracking.service;

import com.project.stockTracking.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.stockTracking.entity.Product;
import com.project.stockTracking.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product productDetails) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        product.setProductName(productDetails.getProductName());
        product.setProductCategory(productDetails.getProductCategory());
        product.setProductMinLimit(productDetails.getProductMinLimit());
        product.setProductMaxLimit(productDetails.getProductMaxLimit());
        product.setUnitName(productDetails.getUnitName());
        product.setPrice(productDetails.getPrice());
        product.setCurrency(productDetails.getCurrency());
        product.setProductDescription(productDetails.getProductDescription());
        product.setBarcodeNumber(productDetails.getBarcodeNumber());
        product.setDate(productDetails.getDate());
        product.setCreatedDate(productDetails.getCreatedDate());
        product.setCreatedBy(productDetails.getCreatedBy());
        product.setUpdatedDate(productDetails.getUpdatedDate());
        product.setUpdatedBy(productDetails.getUpdatedBy());
        product.setIsDeleted(productDetails.getIsDeleted());

        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        productRepository.delete(product);
    }
}