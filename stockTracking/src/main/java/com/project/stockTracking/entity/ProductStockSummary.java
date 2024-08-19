package com.project.stockTracking.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
public class ProductStockSummary extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "productid")
    private Product product;

    private Integer totalAmount;



}