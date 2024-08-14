package com.project.stockTracking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String warehouseName;
    private Integer warehouseCapacity;
    private String warehouseManager;
    private String warehouseAddress;
    private String description;
    private BigDecimal occupancyRate;
    private LocalDateTime createdDate;
    private Integer createdBy;
    private LocalDateTime updatedDate;
    private Integer updatedBy;
    private Boolean isDeleted;

}
