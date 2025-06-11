package com.emergency_system.emergency_system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.emergency_system.emergency_system.repository.IncidentRepository;
import com.emergency_system.emergency_system.entity.IncidentEntity;
import com.emergency_system.emergency_system.service.IncidentService;
import java.util.List;
import java.util.Optional;
import org.springframework.util.Assert;
import jakarta.persistence.EntityNotFoundException;

@Service
public class IncidentServiceImpl implements IncidentService {
    
    @Autowired
    private IncidentRepository incidentRepository;
    
    /**
     * Saves an incident in the database.
     *
     * @param incident the incident to be saved; must not be null and must have a valid description
     * @return the saved incident
     * @throws IllegalArgumentException if the incident is null or its description is empty
     */
    @Override
    public IncidentEntity save(IncidentEntity incident) {
        Assert.notNull(incident, "El incidente no puede ser nulo");
        Assert.hasText(incident.getDescription(), "La descripción del incidente no puede estar vacía");
        Assert.notNull(incident.getLocation(), "La ubicación del incidente no puede ser nula");
        Assert.notNull(incident.getStatus(), "El estado del incidente no puede ser nulo");
        return incidentRepository.save(incident);
    }
    
    /**
     * Retrieves an incident by its ID.
     *
     * @param id the ID of the incident to be retrieved
     * @return an Optional containing the incident if found; empty otherwise
     * @throws IllegalArgumentException if the ID is null or not greater than 0
     */
    @Override
    public Optional<IncidentEntity> findById(Long id) {
        Assert.notNull(id, "El ID no puede ser nulo");
        Assert.isTrue(id > 0, "El ID debe ser mayor que 0");
        return incidentRepository.findById(id);
    }
    
    /**
     * Retrieves all incidents from the database.
     *
     * @return a list of all incidents stored in the database; never null
     * @throws IllegalStateException if no incidents are found
     */
    @Override
    public List<IncidentEntity> findAll() {
        List<IncidentEntity> incidents = incidentRepository.findAll();
        Assert.notEmpty(incidents, "No se encontraron incidentes");
        return incidents;
    }
    
    /**
     * Deletes an incident by its ID.
     *
     * @param id the ID of the incident to be deleted; must not be null and must be greater than 0
     * @throws IllegalArgumentException if the ID is null or not greater than 0
     * @throws EntityNotFoundException if no incident with the given ID is found
     */
    @Override
    public void deleteById(Long id) {
        Assert.notNull(id, "El ID no puede ser nulo");
        Assert.isTrue(id > 0, "El ID debe ser mayor que 0");
        if (!incidentRepository.existsById(id)) {
            throw new EntityNotFoundException("No se encontró el incidente con ID: " + id);
        }
        incidentRepository.deleteById(id);
    }
    
    /**
     * Deletes an incident given by its entity.
     *
     * @param incident the incident to be deleted; must not be null and must have a non-null ID
     * @throws IllegalArgumentException if the incident is null or its ID is null
     * @throws EntityNotFoundException if no incident with the given ID is found
     */
    @Override
    public void delete(IncidentEntity incident) {
        Assert.notNull(incident, "El incidente no puede ser nulo");
        Assert.notNull(incident.getId(), "El ID del incidente no puede ser nulo");
        if (!incidentRepository.existsById(incident.getId())) {
            throw new EntityNotFoundException("No se encontró el incidente con ID: " + incident.getId());
        }
        incidentRepository.delete(incident);
    }
    
    /**
     * Returns the total number of incidents in the database.
     *
     * @return the number of incidents in the database; cannot be negative
     */
    @Override
    public long count() {
        long count = incidentRepository.count();
        Assert.isTrue(count >= 0, "El conteo no puede ser negativo");
        return count;
    }
}
