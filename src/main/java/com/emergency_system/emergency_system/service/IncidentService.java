package com.emergency_system.emergency_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.emergency_system.emergency_system.repository.IncidentRepository;
import com.emergency_system.emergency_system.entity.IncidentEntity;
import java.util.List;
import java.util.Optional;

public class IncidentService {
    IncidentEntity save(IncidentEntity incident);
    Optional<IncidentEntity> findById(Long id);
    List<IncidentEntity> findAll();
    void deleteById(Long id);
    void delete(IncidentEntity incident);
    long count();
}