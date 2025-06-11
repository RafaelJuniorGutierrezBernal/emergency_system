package com.emergency_system.emergency_system.service;

public class ResourceService {
    ResourceEntity save(ResourceEntity resource);
    Optional<ResourceEntity> findById(Long id);
    List<ResourceEntity> findAll();
    void deleteById(Long id);
    void delete(ResourceEntity resource);
    long count();
}
