package com.emergency_system.emergency_system.mapper;

import org.springframework.stereotype.Component;
import com.emergency_system.emergency_system.models.dtos.Request.UserRequestDTO;
import com.emergency_system.emergency_system.models.dtos.Response.UserRespondeDTO;
import com.emergency_system.emergency_system.models.entities.UserEntity;

@Component
public class UserMapper {
    
    /**
     * Converts a UserRequestDTO to UserEntity
     *
     * @param requestDTO the DTO to convert
     * @return the converted entity
     * @throws IllegalArgumentException if the requestDTO is null
     */
    public UserEntity RequestDTOtoEntity(UserRequestDTO requestDTO) {
        if (requestDTO == null) {
            throw new IllegalArgumentException("El DTO de entrada no puede ser nulo");
        }
        
        UserEntity entity = new UserEntity(); 
        entity.setUsername(requestDTO.getUsername());
        entity.setEmail(requestDTO.getEmail());
        entity.setPhoneNumber(requestDTO.getPhoneNumber());
        entity.setFirstName(requestDTO.getFirstName());
        entity.setLastName(requestDTO.getLastName());
        entity.setRole(requestDTO.getRole());
        return entity;
    }
    
    /**
     * Converts a UserEntity to UserResponseDTO
     *
     * @param entity the entity to convert
     * @return the converted DTO
     * @throws IllegalArgumentException if the entity is null
     */
    public UserRespondeDTO EntitytoResponseDTO(UserEntity entity) {
        if (entity == null) {
            throw new IllegalArgumentException("La entidad no puede ser nula");
        }
        
        UserRespondeDTO response = new UserRespondeDTO();
        response.setUsername(entity.getUsername());
        response.setEmail(entity.getEmail());
        response.setFirstName(entity.getFirstName());
        response.setLastName(entity.getLastName());
        response.setCreatedAt(entity.getCreatedAt());
        response.setUpdatedAt(entity.getUpdatedAt());
        response.setRole(entity.getRole());
        return response;
    }
}
