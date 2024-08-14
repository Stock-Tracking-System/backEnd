package com.project.stockTracking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.stockTracking.entity.StockMovement;
import com.project.stockTracking.exception.ResourceNotFoundException;
import com.project.stockTracking.repository.StockMovementRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StockMovementService {

    @Autowired
    private StockMovementRepository stockMovementRepository;

    public List<StockMovement> getAllStockMovements() {
        return stockMovementRepository.findAll();
    }

    public Optional<StockMovement> getStockMovementById(Long id) {
        return stockMovementRepository.findById(id);
    }

    public StockMovement createStockMovement(StockMovement stockMovement) {
        return stockMovementRepository.save(stockMovement);
    }

    public StockMovement updateStockMovement(Long id, StockMovement stockMovementDetails) {
        StockMovement stockMovement = stockMovementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("StockMovement not found with id: " + id));

        stockMovement.setWarehouse(stockMovementDetails.getWarehouse());
        stockMovement.setProduct(stockMovementDetails.getProduct());
        stockMovement.setMovementType(stockMovementDetails.getMovementType());
        stockMovement.setAmount(stockMovementDetails.getAmount());
        stockMovement.setDescription(stockMovementDetails.getDescription());
        stockMovement.setCreatedDate(stockMovementDetails.getCreatedDate());
        stockMovement.setCreatedBy(stockMovementDetails.getCreatedBy());
        stockMovement.setUpdatedDate(stockMovementDetails.getUpdatedDate());
        stockMovement.setUpdatedBy(stockMovementDetails.getUpdatedBy());
        stockMovement.setIsDeleted(stockMovementDetails.getIsDeleted());

        return stockMovementRepository.save(stockMovement);
    }

    public void deleteStockMovement(Long id) {
        StockMovement stockMovement = stockMovementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("StockMovement not found with id: " + id));
        stockMovementRepository.delete(stockMovement);
    }
}