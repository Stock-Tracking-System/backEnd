package com.project.stockTracking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



@Setter
@Getter
@Entity
public class StockMovement extends Auditable{
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





    private Integer createdBy;

    private Integer updatedBy;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;

}
