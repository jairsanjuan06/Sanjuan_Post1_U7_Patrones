package com.example.tareas.repository;

import com.example.tareas.domain.model.EstadoTarea;
import com.example.tareas.domain.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {

    List<Tarea> findByEstado(EstadoTarea estado);

    List<Tarea> findByTituloContainingIgnoreCase(String titulo);
}
