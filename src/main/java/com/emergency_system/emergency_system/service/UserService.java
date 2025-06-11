package com.emergency_system.emergency_system.service;

public class UserService {
    UserEntity save(UserEntity user);
    Optional<UserEntity> findById(Long username);
    List<UserEntity> findAll();
    void deleteById(Long id);
    void delete(UserRepository user);
    long count();
}
