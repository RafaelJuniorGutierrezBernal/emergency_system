package com.emergency_system.emergency_system.mapper;

import org.springframework.stereotype.Component;
import com.emergency_system.emergency_system.models.dtos.Request.IncidentRequestDTO;
import com.emergency_system.emergency_system.models.entities.IncidentEntity;
import com.emergency_system.emergency_system.models.dtos.Response.IncidentResponseDTO;

@Component
public class IncidentMapper {
    
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
        entity.setStatus("NUEVO");
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
        return new IncidentResponseDTO(
            entity.getTitle(),
            entity.getDescription(),
            entity.getLocation(),
            entity.getType(),
            entity.getCreatedAt(),
            entity.getUpdatedAt()
        );
    }
}
