package com.emergency_system.emergency_system.models.dtos.Response;

public class IncidentRespondeDTO {

    private String title;
    private String description;
    private String location;
    private String type;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public IncidentRespondeDTO(String title, String description, String location, String type, String createdAt, String updatedAt) {
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

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
    
}
