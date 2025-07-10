package com.emergency_system.emergency_system.service;

import com.emergency_system.emergency_system.models.entities.IncidentEntity;
import java.util.List;
import java.util.Optional;

public interface IncidentService {
    IncidentEntity save(IncidentEntity incident);
    Optional<IncidentEntity> findById(Long id);
    List<IncidentEntity> findAll();
    void deleteById(Long id);
    void delete(IncidentEntity incident);
    long count();
    IncidentEntity update(Long id, IncidentEntity incident);
    List<IncidentEntity> search(String type, String location);
    IncidentEntity updateStatus(Long id, String status);
}