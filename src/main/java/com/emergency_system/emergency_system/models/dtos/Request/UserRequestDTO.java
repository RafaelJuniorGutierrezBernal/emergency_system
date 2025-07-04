package com.emergency_system.emergency_system.models.dtos.Request;

import com.fasterxml.jackson.annotation.JsonProperty;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * DTO para la solicitud de creación o actualización de usuarios.
 * Contiene las validaciones necesarias para asegurar la integridad de los datos.
 *
 * @author Emergency System Team
 * @version 1.0
 */
public class UserRequestDTO {
    
    /** Nombre de usuario único en el sistema */
    @NotBlank(message = "Username is required to register")
    private String username;
    @NotBlank
    @Email    
    private String email;
    @NotBlank
    @JsonProperty(value="phone_number")
    private String phoneNumber;
    @Size(min = 1, message = "first name must be at least 1 characters")
    @JsonProperty(value="first_name")
    private String firstName;
    @Size(min = 1, message = "Last name must be at least 1 characters")
    @JsonProperty(value="last_name")
    private String lastName;
    @NotBlank
    @JsonProperty(value="role")
    private String role;




    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }


    
    
    
}
