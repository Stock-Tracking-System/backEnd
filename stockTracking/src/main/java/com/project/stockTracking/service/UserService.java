package com.project.stockTracking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.stockTracking.entity.User;
import com.project.stockTracking.repository.UserRepository;
import com.project.stockTracking.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());
        user.setAddress(userDetails.getAddress());
        user.setPhone(userDetails.getPhone());
        user.setEmail(userDetails.getEmail());
        user.setRole(userDetails.getRole());
        user.setCreatedDate(userDetails.getCreatedDate());
        user.setCreatedBy(userDetails.getCreatedBy());
        user.setUpdatedDate(userDetails.getUpdatedDate());
        user.setUpdatedBy(userDetails.getUpdatedBy());
        user.setIsDeleted(userDetails.getIsDeleted());

        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        userRepository.delete(user);
    }
}