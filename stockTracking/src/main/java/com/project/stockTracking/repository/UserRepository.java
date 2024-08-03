package com.project.stockTracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.stockTracking.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}