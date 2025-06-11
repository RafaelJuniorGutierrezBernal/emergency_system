package com.emergency_system.emergency_system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.emergency_system.emergency_system.repository.UserRepository;
import com.emergency_system.emergency_system.entity.UserEntity;
import com.emergency_system.emergency_system.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.util.Assert;
import jakarta.persistence.EntityNotFoundException;
import java.util.regex.Pattern;
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    
    private static final Pattern NAME_PATTERN = Pattern.compile("^[\\p{L} .'-]+$");
    
    
    private UserRepository userRepository;
    private UserMapper userMapper;
    
    /**
     * Saves a user in the database.
     *
     * @param user the user to be saved; must not be null and must have valid data
     * @return the saved user
     * @throws IllegalArgumentException if the user is null or its data is invalid
     */
    @Override
    public UserEntity register(UserEntity user) {
        Assert.notNull(user, "El usuario no puede ser nulo");
        Assert.hasText(user.getName(), "El nombre del usuario no puede estar vacío");
        
        // Validación del nombre con caracteres especiales
        if (!NAME_PATTERN.matcher(user.getFirstName()),user.getLastName().matches()) {
            throw new IllegalArgumentException("El nombre solo puede contener letras, espacios, puntos, guiones y apóstrofes");
        }
        
        Assert.hasText(user.getEmail(), "El email del usuario no puede estar vacío");
        Assert.hasText(user.getPassword(), "La contraseña del usuario no puede estar vacía");
        Assert.notNull(user.getRole(), "El rol del usuario no puede ser nulo");
        return userRepository.save(user);
    }
    
    /**
     * Retrieves a user by its ID.
     *
     * @param id the ID of the user to be retrieved
     * @return an Optional containing the user if found; empty otherwise
     * @throws IllegalArgumentException if the ID is null or not greater than 0
     */
    @Override
    public Optional<UserEntity> findById(Long id) {
        Assert.notNull(id, "El ID no puede ser nulo");
        Assert.isTrue(id > 0, "El ID debe ser mayor que 0");
        return userRepository.findById(id);
    }
    
    /**
     * Retrieves all users from the database.
     *
     * @return a list of all users stored in the database; never null
     * @throws IllegalStateException if no users are found
     */
    @Override
    public List<UserEntity> findAll() {
        List<UserEntity> users = userRepository.findAll();
        Assert.notEmpty(users, "No se encontraron usuarios");
        return users;
    }
    
    /**
     * Deletes a user by its ID.
     *
     * @param id the ID of the user to be deleted; must not be null and must be greater than 0
     * @throws IllegalArgumentException if the ID is null or not greater than 0
     * @throws EntityNotFoundException if no user with the given ID is found
     */
    @Override
    public void deleteById(Long id) {
        Assert.notNull(id, "El ID no puede ser nulo");
        Assert.isTrue(id > 0, "El ID debe ser mayor que 0");
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException("No se encontró el usuario con ID: " + id);
        }
        userRepository.deleteById(id);
    }
    
    /**
     * Deletes a user given by its entity.
     *
     * @param user the user to be deleted; must not be null and must have a non-null ID
     * @throws IllegalArgumentException if the user is null or its ID is null
     * @throws EntityNotFoundException if no user with the given ID is found
     */
    @Override
    public void delete(UserEntity user) {
        Assert.notNull(user, "El usuario no puede ser nulo");
        Assert.notNull(user.getId(), "El ID del usuario no puede ser nulo");
        if (!userRepository.existsById(user.getId())) {
            throw new EntityNotFoundException("No se encontró el usuario con ID: " + user.getId());
        }
        userRepository.delete(user);
    }
    
    /**
     * Returns the total number of users in the database.
     *
     * @return the number of users in the database; cannot be negative
     */
    @Override
    public long count() {
        long count = userRepository.count();
        Assert.isTrue(count >= 0, "El conteo no puede ser negativo");
        return count;
    }
}
