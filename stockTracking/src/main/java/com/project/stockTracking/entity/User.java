package com.project.stockTracking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Setter
@Getter
@Entity
@Table(name = "\"user\"") // Tablo adı kullanıcıda "user" ise çift tırnak içinde belirtin
public class User extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "role")
    private String role;


@Column(name = "is_deleted")
private Boolean isDeleted = false;
}