package com.emergency_system.emergency_system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.emergency_system.emergency_system.repository.ResourceRepository;
import com.emergency_system.emergency_system.entity.ResourceEntity;
import com.emergency_system.emergency_system.service.ResourceService;
import java.util.List;
import java.util.Optional;
import org.springframework.util.Assert;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ResourceServiceImpl implements ResourceService {
    
    @Autowired
    private ResourceRepository resourceRepository;
    
    /**
     * Saves a resource in the database.
     *
     * @param resource the resource to be saved; must not be null and must have a valid name
     * @return the saved resource
     * @throws IllegalArgumentException if the resource is null or its name is empty
     */
    @Override
    public ResourceEntity save(ResourceEntity resource) {
        Assert.notNull(resource, "El recurso no puede ser nulo");
        Assert.hasText(resource.getName(), "El nombre del recurso no puede estar vacío");
        Assert.notNull(resource.getType(), "El tipo de recurso no puede ser nulo");
        Assert.isTrue(resource.getQuantity() >= 0, "La cantidad del recurso no puede ser negativa");
        return resourceRepository.save(resource);
    }
    
    /**
     * Retrieves a resource by its ID.
     *
     * @param id the ID of the resource to be retrieved
     * @return an Optional containing the resource if found; empty otherwise
     * @throws IllegalArgumentException if the ID is null or not greater than 0
     */
    @Override
    public Optional<ResourceEntity> findById(Long id) {
        Assert.notNull(id, "El ID no puede ser nulo");
        Assert.isTrue(id > 0, "El ID debe ser mayor que 0");
        return resourceRepository.findById(id);
    }
    
    /**
     * Retrieves all resources from the database.
     *
     * @return a list of all resources stored in the database; never null
     * @throws IllegalStateException if no resources are found
     */
    @Override
    public List<ResourceEntity> findAll() {
        List<ResourceEntity> resources = resourceRepository.findAll();
        Assert.notEmpty(resources, "No se encontraron recursos");
        return resources;
    }
    
    /**
     * Deletes a resource by its ID.
     *
     * @param id the ID of the resource to be deleted; must not be null and must be greater than 0
     * @throws IllegalArgumentException if the ID is null or not greater than 0
     * @throws EntityNotFoundException if no resource with the given ID is found
     */
    @Override
    public void deleteById(Long id) {
        Assert.notNull(id, "El ID no puede ser nulo");
        Assert.isTrue(id > 0, "El ID debe ser mayor que 0");
        if (!resourceRepository.existsById(id)) {
            throw new EntityNotFoundException("No se encontró el recurso con ID: " + id);
        }
        resourceRepository.deleteById(id);
    }
    
    /**
     * Deletes a resource given by its entity.
     *
     * @param resource the resource to be deleted; must not be null and must have a non-null ID
     * @throws IllegalArgumentException if the resource is null or its ID is null
     * @throws EntityNotFoundException if no resource with the given ID is found
     */
    @Override
    public void delete(ResourceEntity resource) {
        Assert.notNull(resource, "El recurso no puede ser nulo");
        Assert.notNull(resource.getId(), "El ID del recurso no puede ser nulo");
        if (!resourceRepository.existsById(resource.getId())) {
            throw new EntityNotFoundException("No se encontró el recurso con ID: " + resource.getId());
        }
        resourceRepository.delete(resource);
    }
    
    /**
     * Returns the total number of resources in the database.
     *
     * @return the number of resources in the database; cannot be negative
     */
    @Override
    public long count() {
        long count = resourceRepository.count();
        Assert.isTrue(count >= 0, "El conteo no puede ser negativo");
        return count;
    }
}
