package com.project.stockTracking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;

    @ManyToOne
    @JoinColumn(name = "productCategoryid")
    private ProductCategory productCategory;

    private Integer productMinLimit;
    private Integer productMaxLimit;
    private String unitName;
    private BigDecimal price;
    private String currency;
    private String productDescription;
    private String barcodeNumber;
    private LocalDateTime date;
    private LocalDateTime createdDate;
    private Integer createdBy;
    private LocalDateTime updatedDate;
    private Integer updatedBy;
    private Boolean isDeleted;

}
