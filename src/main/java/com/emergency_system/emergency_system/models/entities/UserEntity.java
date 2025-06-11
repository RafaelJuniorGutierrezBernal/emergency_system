package com.emergency_system.emergency_system.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;

/**
 * Entidad que representa a un usuario en el sistema de emergencias.
 * Esta clase almacena la información básica de los usuarios que interactúan con el sistema.
 *
 * @author Emergency System Team
 * @version 1.0
 */
@Entity
public class UserEntity {
    
    /** Nombre de usuario único en el sistema */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String username;
    @Email    
    @Column(name ="email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
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

}
