package com.emergency_system.emergency_system.repository;

import com.emergency_system.emergency_system.models.entities.IncidentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncidentRepository extends JpaRepository<IncidentEntity, Long> {
    // Los métodos CRUD básicos ya están incluidos en JpaRepository:
    // save() - para crear y actualizar
    // findById() - para buscar por ID
    // findAll() - para listar todos
    // deleteById() - para eliminar por ID
    // delete() - para eliminar una entidad
    // count() - para contar registros

    List<IncidentEntity> findByType(String type);
    List<IncidentEntity> findByLocation(String location);
    List<IncidentEntity> findByTypeAndLocation(String type, String location);
}

