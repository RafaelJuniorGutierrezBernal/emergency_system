package com.emergency_system.emergency_system.service;

import java.util.List;
import java.util.Optional;

import com.emergency_system.emergency_system.models.entities.UserEntity;
import com.emergency_system.emergency_system.repository.UserRepository;

public interface UserService {
    UserEntity save(UserEntity user);
    Optional<UserEntity> findById(Long username);
    List<UserEntity> findAll();
    void deleteById(Long id);
    void delete(UserEntity user);
    long count();
}
