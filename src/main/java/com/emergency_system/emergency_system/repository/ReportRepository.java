package com.emergency_system.emergency_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.emergency_system.emergency_system.entity.ReportEntity;

@Repository
public interface ReportRepository extends JpaRepository<ReportEntity, Long> {
    // Los métodos CRUD básicos ya están incluidos en JpaRepository:
    // save() - para crear y actualizar
    // findById() - para buscar por ID
    // findAll() - para listar todos
    // deleteById() - para eliminar por ID
    // delete() - para eliminar una entidad
    // count() - para contar registros
}
