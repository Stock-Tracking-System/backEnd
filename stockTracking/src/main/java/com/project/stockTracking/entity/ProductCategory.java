package com.project.stockTracking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ProductCategory extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoryName;
    private String description;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;
}


