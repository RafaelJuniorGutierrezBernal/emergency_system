package com.emergency_system.emergency_system.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emergency_system.emergency_system.models.entities.UserEntity;
import com.emergency_system.emergency_system.service.UserService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



/**
 * Controlador REST para la gestión de usuarios en el sistema de emergencias.
 * Proporciona endpoints para crear, actualizar, eliminar y consultar usuarios.
 *
 * @author Emergency System Team
 * @version 1.0
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.findAll();
    }
    @PutMapping("{id}")
    public UserEntity updateUser(@PathVariable Long id, @RequestBody UserEntity user) {
        return userService.save(user);
    }
    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
    }
    @GetMapping("{id}")
    public Optional<UserEntity> getUser(@PathVariable Long id) {
        return userService.findById(id);
    }
    
}
