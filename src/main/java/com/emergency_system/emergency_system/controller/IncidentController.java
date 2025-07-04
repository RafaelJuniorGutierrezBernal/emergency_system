package com.emergency_system.emergency_system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PatchMapping;

import com.emergency_system.emergency_system.models.dtos.Request.IncidentRequestDTO;
import com.emergency_system.emergency_system.models.dtos.Response.IncidentResponseDTO;
import com.emergency_system.emergency_system.models.entities.IncidentEntity;
import com.emergency_system.emergency_system.service.IncidentService;
import com.emergency_system.emergency_system.mapper.IncidentMapper;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

/**
 * Controlador REST para la gestión de incidentes en el sistema de emergencias.
 * Proporciona endpoints para:
 * - Creación y actualización de incidentes
 * - Asignación de recursos a incidentes
 * - Seguimiento del estado de incidentes
 * - Generación de reportes de incidentes
 *
 * @author Emergency System Team
 * @version 1.0
 */
@RestController
@RequestMapping("/api/incidents")
public class IncidentController {
    @Autowired
    private IncidentService incidentService;

    @Autowired
    private IncidentMapper incidentMapper;


    /**
     * Devuelve una lista de todos los incidentes registrados en el sistema.
     * 
     * @return una lista de IncidentResponseDTO con los incidentes
     */

    @GetMapping
    public List<IncidentResponseDTO> getAllIncidents() {
        return incidentService.findAll().stream()
            .map(incidentMapper::EntitytoResponseDTO)
            .toList();
    }

    /**
     * Crea un incidente en el sistema.
     * 
     * @param incidentRequestDTO el DTO con los datos del incidente a crear
     * @return el DTO del incidente creado
     * @throws ResponseStatusException si el incidente no se puede crear
     */
    @PostMapping
    public IncidentResponseDTO createIncident(@RequestBody IncidentRequestDTO incidentRequestDTO) {
        IncidentEntity incidentEntity = incidentMapper.RequestDTOtoEntity(incidentRequestDTO);
        IncidentEntity savedIncident = incidentService.save(incidentEntity);
        return incidentMapper.EntitytoResponseDTO(savedIncident);
    }
    /**
     * Actualiza un incidente en el sistema.
     * 
     * @param id el ID del incidente a actualizar
     * @param incidentRequestDTO el DTO con los datos actualizados del incidente
     * @return el DTO del incidente actualizado
     * @throws ResponseStatusException si el incidente no se puede actualizar
     */
    @PutMapping("/{id}")
    public IncidentResponseDTO updateIncident(@PathVariable Long id, @RequestBody IncidentRequestDTO incidentRequestDTO) {
        IncidentEntity incidentEntity = incidentMapper.RequestDTOtoEntity(incidentRequestDTO);
        IncidentEntity updatedIncident = incidentService.update(id, incidentEntity);
        return incidentMapper.EntitytoResponseDTO(updatedIncident);
    }
    /**
     * Elimina un incidente del sistema.
     * 
     * @param id el ID del incidente a eliminar
     * @throws ResponseStatusException si el incidente no se puede eliminar
     */
    @DeleteMapping("/{id}")
    public void deleteIncident(@PathVariable Long id) {
        incidentService.deleteById(id);
    }
    /**
     * Devuelve un incidente por su ID.
     * 
     * @param id el ID del incidente a buscar
     * @return el DTO del incidente encontrado
     * @throws ResponseStatusException si el incidente no se encuentra
     */
    @GetMapping("/{id}")
    public IncidentResponseDTO getIncidentById(@PathVariable Long id) {
        Optional<IncidentEntity> incidentEntity = incidentService.findById(id);
        return incidentEntity.map(incidentMapper::EntitytoResponseDTO)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Incidente no encontrado"));
    }

    /**
     * Busca incidentes por tipo y ubicación.
     * 
     * @param type el tipo de incidente a buscar (opcional)
     * @param location la ubicación del incidente a buscar (opcional)
     * @return una lista de IncidentResponseDTO con los incidentes encontrados
     */
    @GetMapping("/search")
    public List<IncidentResponseDTO> searchIncidents(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String location) {
        return incidentService.search(type, location).stream()
            .map(incidentMapper::EntitytoResponseDTO)
            .toList();
    }

/**
 * Actualiza el estado de un incidente en el sistema.
 * 
 * @param id el ID del incidente a actualizar
 * @param status el nuevo estado del incidente
 * @return el DTO del incidente con el estado actualizado
 * @throws ResponseStatusException si el incidente no se puede actualizar
 */

    @PatchMapping("/{id}/status")
    public IncidentResponseDTO updateIncidentStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        IncidentEntity updated = incidentService.updateStatus(id, status);
        return incidentMapper.EntitytoResponseDTO(updated);
    }
}
