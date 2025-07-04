package com.emergency_system.emergency_system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.emergency_system.emergency_system.repository.IncidentRepository;
import com.emergency_system.emergency_system.models.entities.IncidentEntity;
import com.emergency_system.emergency_system.service.IncidentService;
import java.util.List;
import java.util.Optional;
import org.springframework.util.Assert;
import jakarta.persistence.EntityNotFoundException;

@Service
public class IncidentServiceImpl implements IncidentService {
    
    @Autowired
    private IncidentRepository incidentRepository;
    
    @Override
    public IncidentEntity save(IncidentEntity incident) {
        if (incident == null) {
            throw new IllegalArgumentException("Incident cannot be null");
        }
        if (incident.getDescription() == null || incident.getDescription().isEmpty()) {
            throw new IllegalArgumentException("Incident description cannot be empty");
        }
        if (incident.getLocation() == null) {
            throw new IllegalArgumentException("Incident location cannot be null");
        }
        if (incident.getStatus() == null) {
            throw new EntityNotFoundException("Incident status must be valid");
        }
        return incidentRepository.save(incident);
    }

    @Override
    public Optional<IncidentEntity> findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be greater than 0");
        }
        return incidentRepository.findById(id);
    }

    @Override
    public List<IncidentEntity> findAll() {
        List<IncidentEntity> incidents = incidentRepository.findAll();
        if (incidents.isEmpty()) {
            throw new IllegalStateException("No incidents found");
        }
        return incidents;
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be greater than 0");
        }
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

    @Override
    public IncidentEntity update(Long id, IncidentEntity incident) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be greater than 0");
        }
        if (incident == null) {
            throw new IllegalArgumentException("Incident cannot be null");
        }
        if (incident.getDescription() == null || incident.getDescription().isEmpty()) {
            throw new IllegalArgumentException("Incident description cannot be empty");
        }
        if (incident.getLocation() == null) {
            throw new IllegalArgumentException("Incident location cannot be null");
        }
        if (incident.getStatus() == null) {
            throw new EntityNotFoundException("Incident status must be valid");
        }
        return incidentRepository.save(incident);
    }

    @Override
    public List<IncidentEntity> search(String type, String location) {
        if (type != null && location != null) {
            return incidentRepository.findByTypeAndLocation(type, location);
        } else if (type != null) {
            return incidentRepository.findByType(type);
        } else if (location != null) {
            return incidentRepository.findByLocation(location);
        } else {
            return incidentRepository.findAll();
        }
    }

    @Override
    public IncidentEntity updateStatus(Long id, String status) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be greater than 0");
        }
        if (status == null || status.isEmpty()) {
            throw new IllegalArgumentException("Status cannot be null or empty");
        }
        IncidentEntity incident = incidentRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("No se encontró el incidente con ID: " + id));
        incident.setStatus(status);
        return incidentRepository.save(incident);
    }
}
