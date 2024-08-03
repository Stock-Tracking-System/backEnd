package com.project.stockTracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.project.stockTracking.entity.ProductStockSummary;
import com.project.stockTracking.service.ProductStockSummaryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product-stock-summaries")
public class ProductStockSummaryController {

    @Autowired
    private ProductStockSummaryService productStockSummaryService;

    @GetMapping
    public ResponseEntity<List<ProductStockSummary>> getAllProductStockSummaries() {
        List<ProductStockSummary> productStockSummaries = productStockSummaryService.getAllProductStockSummaries();
        return ResponseEntity.ok(productStockSummaries);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductStockSummary> getProductStockSummaryById(@PathVariable Long id) {
        Optional<ProductStockSummary> productStockSummary = productStockSummaryService.getProductStockSummaryById(id);
        return productStockSummary.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<ProductStockSummary> createProductStockSummary(@RequestBody ProductStockSummary productStockSummary) {
        ProductStockSummary createdProductStockSummary = productStockSummaryService.createProductStockSummary(productStockSummary);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProductStockSummary);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductStockSummary> updateProductStockSummary(
            @PathVariable Long id, @RequestBody ProductStockSummary productStockSummaryDetails) {
        ProductStockSummary updatedProductStockSummary = productStockSummaryService.updateProductStockSummary(id, productStockSummaryDetails);
        return ResponseEntity.ok(updatedProductStockSummary);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductStockSummary(@PathVariable Long id) {
        productStockSummaryService.deleteProductStockSummary(id);
        return ResponseEntity.noContent().build();
    }
}