package com.project.stockTracking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Setter
@Getter
@Entity
public class Product extends Auditable {
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
    private BigDecimal volumePerUnit;

    private Integer createdBy;

    private Integer updatedBy;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;


}
