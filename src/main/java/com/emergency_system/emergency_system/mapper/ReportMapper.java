package com.emergency_system.emergency_system.mapper;

import org.springframework.stereotype.Component;
import com.emergency_system.emergency_system.models.dtos.Request.ReportRequestDTO;
import com.emergency_system.emergency_system.models.dtos.Response.ReportResponseDTO;
import com.emergency_system.emergency_system.models.entities.ReportEntity;

@Component
public class ReportMapper {
    
    /**
     * Converts a ReportRequestDTO to ReportEntity
     *
     * @param requestDTO the DTO to convert
     * @return the converted entity
     * @throws IllegalArgumentException if the requestDTO is null
     */
    public ReportEntity RequestDTOtoEntity(ReportRequestDTO requestDTO) {
        if (requestDTO == null) {
            throw new IllegalArgumentException("El DTO de entrada no puede ser nulo");
        }
        
        ReportEntity entity = new ReportEntity(); 
        entity.setDescription(requestDTO.getReportDescription());
        return entity;
    }
    
    /**
     * Converts a ReportEntity to ReportResponseDTO
     *
     * @param entity the entity to convert
     * @return the converted DTO
     * @throws IllegalArgumentException if the entity is null
     */
    public ReportResponseDTO EntitytoResponseDTO(ReportEntity entity) {
        if (entity == null) {
            throw new IllegalArgumentException("La entidad no puede ser nula");
        }
        
        ReportResponseDTO response = new ReportResponseDTO();
        response.setReportId(entity.getId() != null ? entity.getId().toString() : null);
        response.setReportDescription(entity.getDescription());
        return response;
    }
}
