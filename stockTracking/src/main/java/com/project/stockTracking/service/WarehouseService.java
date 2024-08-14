package com.project.stockTracking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.stockTracking.entity.Warehouse;
import com.project.stockTracking.repository.WarehouseRepository;
import com.project.stockTracking.exception.ResourceNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {

    @Autowired
    private WarehouseRepository warehouseRepository;

    public List<Warehouse> getAllWarehouses() {
        return warehouseRepository.findAll();
    }

    public Optional<Warehouse> getWarehouseById(Long id) {
        return warehouseRepository.findById(id);
    }

    @Transactional
    public Warehouse createWarehouse(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }

    @Transactional
    public Warehouse updateWarehouse(Long id, Warehouse warehouseDetails) {
        Warehouse warehouse = warehouseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Warehouse not found"));

        warehouse.setWarehouseName(warehouseDetails.getWarehouseName());
        warehouse.setWarehouseCapacity(warehouseDetails.getWarehouseCapacity());
        warehouse.setWarehouseManager(warehouseDetails.getWarehouseManager());
        warehouse.setWarehouseAddress(warehouseDetails.getWarehouseAddress());
        warehouse.setDescription(warehouseDetails.getDescription());
        warehouse.setOccupancyRate(warehouseDetails.getOccupancyRate());
        warehouse.setCreatedDate(warehouseDetails.getCreatedDate());
        warehouse.setCreatedBy(warehouseDetails.getCreatedBy());
        warehouse.setUpdatedDate(warehouseDetails.getUpdatedDate());
        warehouse.setUpdatedBy(warehouseDetails.getUpdatedBy());
        warehouse.setIsDeleted(warehouseDetails.getIsDeleted());

        return warehouseRepository.save(warehouse);
    }

    @Transactional
    public void deleteWarehouse(Long id) {
        Warehouse warehouse = warehouseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Warehouse not found"));
        warehouse.setIsDeleted(true);
        warehouseRepository.save(warehouse);
    }
}
