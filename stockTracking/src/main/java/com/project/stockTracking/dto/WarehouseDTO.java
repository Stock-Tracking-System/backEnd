package com.project.stockTracking.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class WarehouseDTO {
    private String warehouseName;
    private Integer warehouseCapacity;
    private String warehouseManager;
    private String warehouseAddress;
    private String description;
    private LocalDateTime date;

}