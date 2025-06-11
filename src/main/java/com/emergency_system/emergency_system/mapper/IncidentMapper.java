package com.emergency_system.emergency_system.mapper;

import com.emergency_system.emergency_system.entity.IncidentEntity;
import com.emergency_system.emergency_system.dto.request.IncidentRequestDTO;
import com.emergency_system.emergency_system.dto.response.IncidentResponseDTO;

public interface IncidentMapper {
    
    /**
     * Converts an IncidentRequestDTO to IncidentEntity
     *
     * @param requestDTO the DTO to convert
     * @return the converted entity
     * @throws IllegalArgumentException if the requestDTO is null
     */
    public IncidentEntity RequestDTOtoEntity(IncidentRequestDTO requestDTO) {
        if (requestDTO == null) {
            throw new IllegalArgumentException("El DTO de entrada no puede ser nulo");
        }
        
        IncidentEntity entity = new IncidentEntity(); 
        entity.setTitle(requestDTO.getTitle());
        entity.setDescription(requestDTO.getDescription());
        entity.setLocation(requestDTO.getLocation());
        entity.setType(requestDTO.getType());
        return entity;
    }
    
    /**
     * Converts an IncidentEntity to IncidentResponseDTO
     *
     * @param entity the entity to convert
     * @return the converted DTO
     * @throws IllegalArgumentException if the entity is null
     */
    public IncidentResponseDTO EntitytoResponseDTO(IncidentEntity entity) {
        if (entity == null) {
            throw new IllegalArgumentException("La entidad no puede ser nula");
        }
        
        IncidentResponseDTO response = new IncidentResponseDTO();
        response.setTitle(entity.getTitle());
        response.setDescription(entity.getDescription());
        response.setLocation(entity.getLocation());
        response.setType(entity.getType());
        response.setCreatedAt(entity.getCreatedAt());
        response.setUpdatedAt(entity.getUpdatedAt());
        return response;
    }
}
