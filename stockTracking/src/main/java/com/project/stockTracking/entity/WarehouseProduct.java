package com.project.stockTracking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class WarehouseProduct extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "warehouseid")
    private Warehouse warehouse;

    @ManyToOne
    @JoinColumn(name = "productid")
    private Product product;

    private Integer totalAmount;

    private Integer createdBy;

    private Integer updatedBy;


}

