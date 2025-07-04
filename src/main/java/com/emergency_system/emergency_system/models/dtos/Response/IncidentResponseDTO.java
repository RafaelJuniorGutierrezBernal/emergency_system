package com.emergency_system.emergency_system.models.dtos.Response;

import java.time.LocalDate;

public class IncidentResponseDTO {

    private String title;
    private String description;
    private String location;
    private String type;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public IncidentResponseDTO(String title, String description, String location, String type, LocalDate createdAt, LocalDate updatedAt) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.type = type;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }
    
}
