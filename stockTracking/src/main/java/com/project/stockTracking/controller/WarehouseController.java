package com.project.stockTracking.controller;



import com.project.stockTracking.dto.WarehouseDTO;
import com.project.stockTracking.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.project.stockTracking.entity.Warehouse;
import com.project.stockTracking.service.WarehouseService;

import java.util.List;


@RestController
@RequestMapping("/api/warehouses")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    @GetMapping
    public List<Warehouse> getAllWarehouses() {
        return warehouseService.getAllWarehouses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<WarehouseDTO> getWarehouseById(@PathVariable Long id) {
        Warehouse warehouse = warehouseService.getWarehouseById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Warehouse not found"));

        WarehouseDTO warehouseDTO = new WarehouseDTO();
        warehouseDTO.setWarehouseName(warehouse.getWarehouseName());
        warehouseDTO.setWarehouseCapacity(warehouse.getWarehouseCapacity());
        warehouseDTO.setWarehouseManager(warehouse.getWarehouseManager());
        warehouseDTO.setWarehouseAddress(warehouse.getWarehouseAddress());
        warehouseDTO.setDescription(warehouse.getDescription());


        return ResponseEntity.ok(warehouseDTO);
    }

    @PostMapping
    public ResponseEntity<Warehouse> createWarehouse(@RequestBody Warehouse warehouse) {
        Warehouse createdWarehouse = warehouseService.createWarehouse(warehouse);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdWarehouse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Warehouse> updateWarehouse(
            @PathVariable Long id, @RequestBody Warehouse warehouseDetails) {
        Warehouse updatedWarehouse = warehouseService.updateWarehouse(id, warehouseDetails);
        return ResponseEntity.ok(updatedWarehouse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWarehouse(@PathVariable Long id) {
        warehouseService.deleteWarehouse(id);
        return ResponseEntity.noContent().build();
    }
}