package com.project.stockTracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.project.stockTracking.entity.WarehouseProduct;
import com.project.stockTracking.service.WarehouseProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/warehouse-products")
public class WarehouseProductController {

    @Autowired
    private WarehouseProductService warehouseProductService;

    @GetMapping
    public List<WarehouseProduct> getAllWarehouseProducts() {
        return warehouseProductService.getAllWarehouseProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<WarehouseProduct> getWarehouseProductById(@PathVariable Long id) {
        Optional<WarehouseProduct> warehouseProduct = warehouseProductService.getWarehouseProductById(id);
        return warehouseProduct.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<WarehouseProduct> createWarehouseProduct(@RequestBody WarehouseProduct warehouseProduct) {
        WarehouseProduct createdWarehouseProduct = warehouseProductService.createWarehouseProduct(warehouseProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdWarehouseProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WarehouseProduct> updateWarehouseProduct(
            @PathVariable Long id, @RequestBody WarehouseProduct warehouseProductDetails) {
        WarehouseProduct updatedWarehouseProduct = warehouseProductService.updateWarehouseProduct(id, warehouseProductDetails);
        return ResponseEntity.ok(updatedWarehouseProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWarehouseProduct(@PathVariable Long id) {
        warehouseProductService.deleteWarehouseProduct(id);
        return ResponseEntity.noContent().build();
    }
}