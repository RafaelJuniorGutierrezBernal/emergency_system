package com.emergency_system.emergency_system.models.dtos.Request;

public class ResourceRequestDTO {
    private String name;
    private String description;
    private String type;
    private String currentLatitude;
    private String currentLongitude;

    public ResourceRequestDTO(String name, String description, String type, String currentLatitude, String currentLongitude) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.currentLatitude = currentLatitude;
        this.currentLongitude = currentLongitude;
    }

    public String getName() {
        return name;
    }

   

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCurrentLatitude(String currentLatitude) {
        this.currentLatitude = currentLatitude;
    }

    public void setCurrentLongitude(String currentLongitude) {
        this.currentLongitude = currentLongitude;
    }

    public String getDescription() {
        return description;
    }

   

    public String getType() {
        return type;
    }

    

    public String getCurrentLatitude() {
        return currentLatitude;
    }

   

    public String getCurrentLongitude() {
        return currentLongitude;
    }

    

}
