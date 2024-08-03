package com.project.stockTracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.project.stockTracking.entity.StockMovement;
import com.project.stockTracking.service.StockMovementService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/stock-movements")
public class StockMovementController {

    @Autowired
    private StockMovementService stockMovementService;

    @GetMapping
    public ResponseEntity<List<StockMovement>> getAllStockMovements() {
        List<StockMovement> stockMovements = stockMovementService.getAllStockMovements();
        return ResponseEntity.ok(stockMovements);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockMovement> getStockMovementById(@PathVariable Long id) {
        Optional<StockMovement> stockMovement = stockMovementService.getStockMovementById(id);
        return stockMovement.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<StockMovement> createStockMovement(@RequestBody StockMovement stockMovement) {
        StockMovement createdStockMovement = stockMovementService.createStockMovement(stockMovement);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStockMovement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StockMovement> updateStockMovement(
            @PathVariable Long id, @RequestBody StockMovement stockMovementDetails) {
        StockMovement updatedStockMovement = stockMovementService.updateStockMovement(id, stockMovementDetails);
        return ResponseEntity.ok(updatedStockMovement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStockMovement(@PathVariable Long id) {
        stockMovementService.deleteStockMovement(id);
        return ResponseEntity.noContent().build();
    }
}