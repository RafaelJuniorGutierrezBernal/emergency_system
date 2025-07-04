package com.emergency_system.emergency_system.service;

import java.util.List;
import java.util.Optional;

import com.emergency_system.emergency_system.models.entities.ResourceEntity;

public interface ResourceService {
    ResourceEntity save(ResourceEntity resource);
    Optional<ResourceEntity> findById(Long id);
    List<ResourceEntity> findAll();
    void deleteById(Long id);
    void delete(ResourceEntity resource);
    long count();
}
