package com.project.stockTracking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class StockMovement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "warehouseid")
    private Warehouse warehouse;

    @ManyToOne
    @JoinColumn(name = "productid")
    private Product product;

    private String movementType;
    private Integer amount;
    private String description;
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;

    private LocalDateTime createdDate;
    private Integer createdBy;
    private LocalDateTime updatedDate;
    private Integer updatedBy;
    private Boolean isDeleted;

}
