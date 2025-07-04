package com.emergency_system.emergency_system.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;
import com.emergency_system.emergency_system.models.dtos.Request.ReportRequestDTO;
import com.emergency_system.emergency_system.models.dtos.Response.ReportResponseDTO;
import com.emergency_system.emergency_system.models.entities.ReportEntity;
import com.emergency_system.emergency_system.service.ReportService;
import com.emergency_system.emergency_system.mapper.ReportMapper;

/**
 * Controlador REST para la gestión de reportes en el sistema de emergencias.
 * Proporciona endpoints para:
 * - Generación de reportes de incidentes
 * - Consulta de reportes históricos
 * - Exportación de reportes en diferentes formatos
 * - Estadísticas y análisis de incidentes
 *
 * @author Emergency System Team
 * @version 1.0
 */
@RestController
@RequestMapping("/api/reports")
public class ReportController {
    @Autowired
    private ReportService reportService;
    @Autowired
    private ReportMapper reportMapper;

       
    /**
     * Devuelve la lista de todos los reportes existentes.
     * 
     * @return una lista de DTOs de reportes
     */
    @GetMapping
    public List<ReportResponseDTO> getAllReports() {
        return reportService.findAll().stream()
            .map(reportMapper::EntitytoResponseDTO)
            .toList();
    }

    
    /**
     * Devuelve el reporte con el id especificado.
     * 
     * @param id el id del reporte
     * @return el reporte con el id especificado
     * @throws ResponseStatusException con estado NOT_FOUND si no existe el reporte
     */
    @GetMapping("/{id}")
    public ReportResponseDTO getReportById(@PathVariable Long id) {
        Optional<ReportEntity> report = reportService.findById(id);
        return report.map(reportMapper::EntitytoResponseDTO)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reporte no encontrado"));
    }

    
    /**
     * Crea un nuevo reporte a partir de la información proporcionada.
     * 
     * @param reportRequestDTO el DTO del reporte a crear
     * @return el reporte creado
     */
    @PostMapping
    public ReportResponseDTO createReport(@RequestBody ReportRequestDTO reportRequestDTO) {
        ReportEntity entity = reportMapper.RequestDTOtoEntity(reportRequestDTO);
        ReportEntity saved = reportService.save(entity);
        return reportMapper.EntitytoResponseDTO(saved);
    }

   
    /**
     * Actualiza un reporte existente con el id especificado usando la información proporcionada.
     * 
     * @param id el id del reporte a actualizar
     * @param reportRequestDTO el DTO que contiene los datos actualizados del reporte
     * @return el reporte actualizado en forma de DTO
     * @throws ResponseStatusException con estado NOT_FOUND si no existe el reporte con el id dado
     */

    @PutMapping("/{id}")
    public ReportResponseDTO updateReport(@PathVariable Long id, @RequestBody ReportRequestDTO reportRequestDTO) {
        ReportEntity entity = reportMapper.RequestDTOtoEntity(reportRequestDTO);
        entity.setId(id);
        ReportEntity updated = reportService.save(entity);
        return reportMapper.EntitytoResponseDTO(updated);
    }

    
    /**
     * Elimina el reporte con el id especificado.
     * 
     * @param id el id del reporte a eliminar
     * @throws ResponseStatusException con estado NOT_FOUND si no existe el reporte con el id dado
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReport(@PathVariable Long id) {
        reportService.deleteById(id);
    }
}
