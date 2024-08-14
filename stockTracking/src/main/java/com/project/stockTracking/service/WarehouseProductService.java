package com.project.stockTracking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.stockTracking.entity.WarehouseProduct;
import com.project.stockTracking.repository.WarehouseProductRepository;
import com.project.stockTracking.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseProductService {

    @Autowired
    private WarehouseProductRepository warehouseProductRepository;

    public List<WarehouseProduct> getAllWarehouseProducts() {
        return warehouseProductRepository.findAll();
    }

    public Optional<WarehouseProduct> getWarehouseProductById(Long id) {
        return warehouseProductRepository.findById(id);
    }

    public WarehouseProduct createWarehouseProduct(WarehouseProduct warehouseProduct) {
        return warehouseProductRepository.save(warehouseProduct);
    }

    public WarehouseProduct updateWarehouseProduct(Long id, WarehouseProduct warehouseProductDetails) {
        WarehouseProduct warehouseProduct = warehouseProductRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("WarehouseProduct not found"));

        warehouseProduct.setWarehouse(warehouseProductDetails.getWarehouse());
        warehouseProduct.setProduct(warehouseProductDetails.getProduct());
        warehouseProduct.setTotalAmount(warehouseProductDetails.getTotalAmount());
        warehouseProduct.setCreatedDate(warehouseProductDetails.getCreatedDate());
        warehouseProduct.setCreatedBy(warehouseProductDetails.getCreatedBy());
        warehouseProduct.setUpdatedDate(warehouseProductDetails.getUpdatedDate());
        warehouseProduct.setUpdatedBy(warehouseProductDetails.getUpdatedBy());


        return warehouseProductRepository.save(warehouseProduct);
    }

    public void deleteWarehouseProduct(Long id) {
        WarehouseProduct warehouseProduct = warehouseProductRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("WarehouseProduct not found"));
        warehouseProductRepository.delete(warehouseProduct);
    }
}
