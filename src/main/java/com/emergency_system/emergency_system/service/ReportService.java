package com.emergency_system.emergency_system.service;

import java.util.List;
import java.util.Optional;

import com.emergency_system.emergency_system.models.entities.ReportEntity;

public interface ReportService {
    ReportEntity save(ReportEntity report);
    Optional<ReportEntity> findById(Long id);
    List<ReportEntity> findAll();
    void deleteById(Long id);
    void delete(ReportEntity report);
    long count();
}
