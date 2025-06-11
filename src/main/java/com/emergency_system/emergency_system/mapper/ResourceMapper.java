package com.emergency_system.emergency_system.mapper;

import com.emergency_system.emergency_system.entity.ResourceEntity;
import com.emergency_system.emergency_system.dto.request.ResourceRequestDTO;
import com.emergency_system.emergency_system.dto.response.ResourceResponseDTO;

public interface ResourceMapper {
    
    /**
     * Converts a ResourceRequestDTO to ResourceEntity
     *
     * @param requestDTO the DTO to convert
     * @return the converted entity
     * @throws IllegalArgumentException if the requestDTO is null
     */
    public ResourceEntity RequestDTOtoEntity(ResourceRequestDTO requestDTO) {
        if (requestDTO == null) {
            throw new IllegalArgumentException("El DTO de entrada no puede ser nulo");
        }
        
        ResourceEntity entity = new ResourceEntity(); 
        entity.setName(requestDTO.getName());
        entity.setDescription(requestDTO.getDescription());
        entity.setType(requestDTO.getType());
        entity.setCurrentLatitude(requestDTO.getCurrentLatitude());
        entity.setCurrentLongitude(requestDTO.getCurrentLongitude());
        return entity;
    }
    
    /**
     * Converts a ResourceEntity to ResourceResponseDTO
     *
     * @param entity the entity to convert
     * @return the converted DTO
     * @throws IllegalArgumentException if the entity is null
     */
    public ResourceResponseDTO EntitytoResponseDTO(ResourceEntity entity) {
        if (entity == null) {
            throw new IllegalArgumentException("La entidad no puede ser nula");
        }
        
        ResourceResponseDTO response = new ResourceResponseDTO();
        response.setName(entity.getName());
        response.setDescription(entity.getDescription());
        response.setType(entity.getType());
        response.setCurrentLatitude(entity.getCurrentLatitude());
        response.setCurrentLongitude(entity.getCurrentLongitude());
        return response;
    }
}
