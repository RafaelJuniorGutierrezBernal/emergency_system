package com.emergency_system.emergency_system.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;
import com.emergency_system.emergency_system.models.dtos.Request.ResourceRequestDTO;
import com.emergency_system.emergency_system.models.dtos.Response.ResourceResponseDTO;
import com.emergency_system.emergency_system.models.entities.ResourceEntity;
import com.emergency_system.emergency_system.service.ResourceService;
import com.emergency_system.emergency_system.mapper.ResourceMapper;

/**
 * Controlador REST para la gestión de recursos en el sistema de emergencias.
 * Maneja las operaciones CRUD para recursos como vehículos, equipos y personal.
 * Incluye funcionalidades para:
 * - Asignación de recursos a incidentes
 * - Seguimiento de ubicación
 * - Gestión de estado de recursos
 *
 * @author Emergency System Team
 * @version 1.0
 */
@RestController
@RequestMapping("/api/resources")
public class ResourceController {
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private ResourceMapper resourceMapper;

   
    /**
     * Devuelve la lista de todos los recursos existentes en el sistema.
     * 
     * @return una lista de DTOs de recursos
     */
    @GetMapping
    public List<ResourceResponseDTO> getAllResources() {
        return resourceService.findAll().stream()
            .map(resourceMapper::EntitytoResponseDTO)
            .toList();
    }

   
    /**
     * Devuelve el recurso con el id especificado.
     * 
     * @param id el id del recurso a buscar
     * @return el recurso con el id especificado
     * @throws ResponseStatusException con estado NOT_FOUND si no existe el recurso
     */
    @GetMapping("/{id}")
    public ResourceResponseDTO getResourceById(@PathVariable Long id) {
        Optional<ResourceEntity> resource = resourceService.findById(id);
        return resource.map(resourceMapper::EntitytoResponseDTO)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recurso no encontrado"));
    }

   
    /**
     * Crea un nuevo recurso con la información proporcionada.
     * 
     * @param resourceRequestDTO el DTO del recurso a crear
     * @return el recurso creado como DTO de respuesta
     */
    @PostMapping
    public ResourceResponseDTO createResource(@RequestBody ResourceRequestDTO resourceRequestDTO) {
        ResourceEntity entity = resourceMapper.RequestDTOtoEntity(resourceRequestDTO);
        ResourceEntity saved = resourceService.save(entity);
        return resourceMapper.EntitytoResponseDTO(saved);
    }

    
    /**
     * Actualiza un recurso existente con el ID especificado.
     * 
     * @param id el ID del recurso que se va a actualizar
     * @param resourceRequestDTO el DTO con la información actualizada del recurso
     * @return el recurso actualizado como DTO de respuesta
     * @throws ResponseStatusException con estado NOT_FOUND si no existe el recurso con el ID dado
     */

    @PutMapping("/{id}")
    public ResourceResponseDTO updateResource(@PathVariable Long id, @RequestBody ResourceRequestDTO resourceRequestDTO) {
        ResourceEntity entity = resourceMapper.RequestDTOtoEntity(resourceRequestDTO);
        entity.setId(id);
        ResourceEntity updated = resourceService.save(entity);
        return resourceMapper.EntitytoResponseDTO(updated);
    }

    
    /**
     * Elimina un recurso con el ID especificado.
     * 
     * @param id el ID del recurso a eliminar
     * @throws ResponseStatusException con estado NOT_FOUND si no existe el recurso con el ID dado
     */

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteResource(@PathVariable Long id) {
        resourceService.deleteById(id);
    }
}