package com.emergency_system.emergency_system.mapper;

import com.emergency_system.emergency_system.entity.UserEntity;
import com.emergency_system.emergency_system.dto.request.UserRequestDTO;
import com.emergency_system.emergency_system.dto.response.UserResponseDTO;

public interface UserMapper {
    
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
        return entity;
    }
    
    /**
     * Converts a UserEntity to UserResponseDTO
     *
     * @param entity the entity to convert
     * @return the converted DTO
     * @throws IllegalArgumentException if the entity is null
     */
    public UserResponseDTO EntitytoResponseDTO(UserEntity entity) {
        if (entity == null) {
            throw new IllegalArgumentException("La entidad no puede ser nula");
        }
        
        UserResponseDTO response = new UserResponseDTO();
        response.setUsername(entity.getUsername());
        response.setEmail(entity.getEmail());
        response.setFirstName(entity.getFirstName());
        response.setLastName(entity.getLastName());
        response.setCreatedAt(entity.getCreatedAt());
        response.setUpdatedAt(entity.getUpdatedAt());
        return response;
    }
}
