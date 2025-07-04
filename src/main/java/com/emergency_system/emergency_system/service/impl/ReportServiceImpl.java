package com.emergency_system.emergency_system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.emergency_system.emergency_system.repository.ReportRepository;
import com.emergency_system.emergency_system.models.entities.ReportEntity;
import com.emergency_system.emergency_system.models.entities.ResourceEntity;
import com.emergency_system.emergency_system.service.ReportService;
import java.util.List;
import java.util.Optional;
import org.springframework.util.Assert;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ReportServiceImpl implements ReportService {
    
    @Autowired
    private ReportRepository reportRepository;
    
    /**
     * Saves a report in the database.
     *
     * @param report the report to be saved; must not be null and must have a non-null ID
     * @return the saved report
     * @throws IllegalArgumentException if the report is null or its description is empty or its incident or user are null
     */

    @Override
    public com.emergency_system.emergency_system.models.entities.ReportEntity save(com.emergency_system.emergency_system.models.entities.ReportEntity report) {
        Assert.notNull(report, "El reporte no puede ser nulo");
        Assert.hasText(report.getDescription(), "La descripción del reporte no puede estar vacía");
        return reportRepository.save(report);
    }

    /**
     * Retrieves a report by its ID.
     *
     * @param id the ID of the report to be retrieved
     * @return an optional containing the report if found; otherwise an empty optional
     * @throws IllegalArgumentException if the ID is null or not greater than 0
     */
   

    @Override
    public Optional<ReportEntity> findById(Long id) {
        Assert.notNull(id, "El ID no puede ser nulo");
        Assert.isTrue(id > 0, "El ID debe ser mayor que 0");
        return reportRepository.findById(id);
    }
    

    /**
     * Retrieves all reports from the database.
     *
     * @return a list of all reports stored in the database; never null and never empty
     */

    @Override
    public List<ReportEntity> findAll() {
        List<ReportEntity> reports = reportRepository.findAll();
        Assert.notEmpty(reports, "No se encontraron reportes");
        return reports;
    }
    

/**
 * Deletes a report by its ID.
 *
 * @param id the ID of the report to be deleted; must not be null and must be greater than 0
 * @throws IllegalArgumentException if the ID is null or less than or equal to 0
 * @throws EntityNotFoundException if no report with the given ID is found
 */


    @Override
    public void deleteById(Long id) {
        Assert.notNull(id, "El ID no puede ser nulo");
        Assert.isTrue(id > 0, "El ID debe ser mayor que 0");
        if (!reportRepository.existsById(id)) {
            throw new EntityNotFoundException("No se encontró el reporte con ID: " + id);
        }
        reportRepository.deleteById(id);
    }
    

    /**
     * Deletes a report given by its entity.
     *
     * @param report the report to be deleted; must not be null and must have a non-null ID
     * @throws IllegalArgumentException if the report is null or its ID is null
     * @throws EntityNotFoundException if no report with the given ID is found
    */
    @Override
    public void delete(ReportEntity report) {
        Assert.notNull(report, "El reporte no puede ser nulo");
        Assert.notNull(report.getId(), "El ID del reporte no puede ser nulo");
        if (!reportRepository.existsById(report.getId())) {
            throw new EntityNotFoundException("No se encontró el reporte con ID: " + report.getId());
        }
        reportRepository.delete(report);
    }
    

    /**
     * Returns the number of reports in the database.
     *
     * @return the number of reports in the database; cannot be negative
     */

    @Override
    public long count() {
        long count = reportRepository.count();
        Assert.isTrue(count >= 0, "El conteo no puede ser negativo");
        return count;
    }

}
