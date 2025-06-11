package com.emergency_system.emergency_system.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import java.time.LocalDateTime;

/**
 * Entidad que representa un recurso en el sistema de emergencias.
 * Los recursos pueden ser vehículos, equipos, personal o cualquier otro elemento
 * que pueda ser asignado a una emergencia.
 *
 * @author Emergency System Team
 * @version 1.0
 */
@Entity
public class ResourceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Nombre descriptivo del recurso */
    private String name; 

    /** Tipo de recurso (ej: ambulancia, bomberos, policía) */
    private String type;

    /** Descripción detallada del recurso */
    private String description;

    /** Latitud actual del recurso */
    private String currentLatitude; 

    /** Longitud actual del recurso */
    private String currentLongitude; 

    /** Estado actual del recurso */
    @Enumerated(EnumType.STRING)
    private ResourceStatus status; 

    /** Fecha y hora de creación del registro */
    private LocalDateTime createdAt;

    /** Fecha y hora de la última actualización */
    private LocalDateTime updatedAt;

    /**
     * Enum que define los posibles estados de un recurso en el sistema.
     */
    public enum ResourceStatus {
        /** Recurso disponible para ser asignado */
        AVAILABLE,       // Disponible para asignación
        /** Recurso asignado a un incidente */
        ASSIGNED,        // Asignado a un incidente
        /** Recurso en camino a un incidente/ubicación */
        IN_TRANSIT,      // En camino a un incidente/ubicación
        /** Recurso presente en la escena del incidente */
        ON_SCENE,        // En la escena del incidente
        /** Recurso no disponible (mantenimiento, descanso, etc.) */
        UNAVAILABLE,     // No disponible (por mantenimiento, descanso, etc.)
        /** Recurso regresando de una asignación */
        RETURNING        // Regresando de una asignación
    }

    // --- Getters y Setters ---
    // (Añadir aquí)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getCurrentLatitude() { return currentLatitude; }
    public void setCurrentLatitude(String currentLatitude) { this.currentLatitude = currentLatitude; }
    public String getCurrentLongitude() { return currentLongitude; }
    public void setCurrentLongitude(String currentLongitude) { this.currentLongitude = currentLongitude; }
    public ResourceStatus getStatus() { return status; }
    public void setStatus(ResourceStatus status) { this.status = status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}