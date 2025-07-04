package com.emergency_system.emergency_system.models.dtos.Request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class IncidentRequestDTO {
    @NotBlank(message = "Title is a required field, Please enter a title to continue.")
    @Size(min = 3, max = 50, message = "Title must be between 3 and 50 characters")
    private String title;
    @NotBlank(message = "Description is a required field, Please enter a description to continue.") 
    @Size(min = 3, max = 500, message = "Description must be between 3 and 500 characters")
    private String description;
    @NotBlank(message = "Location is a required field, Please enter a location to continue.")
    @Size(min = 3, max = 50, message = "Location must be between 3 and 50 characters")
    private String location;
    @NotBlank(message = "Type is a required field, Please enter a type to continue.")
    @Size(min = 3, max = 50, message = "Type must be between 3 and 50 characters")
    private String type;
    
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
    
    public void setCreatedAt(LocalDate createdAt) {
        
    }
    public void setUpdatedAt(LocalDate updatedAt) {
       
    }

    
    
}
