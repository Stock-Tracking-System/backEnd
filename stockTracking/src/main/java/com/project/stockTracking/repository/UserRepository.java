
package com.project.stockTracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.stockTracking.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsernameAndPasswordAndIsDeletedFalse(String username, String password);
    List<User> findByIsDeletedFalse();
}
