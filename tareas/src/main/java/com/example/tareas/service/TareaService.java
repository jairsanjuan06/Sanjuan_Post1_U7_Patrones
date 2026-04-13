package com.example.tareas.service;

import com.example.tareas.domain.TareaNotFoundException;
import com.example.tareas.domain.model.EstadoTarea;
import com.example.tareas.domain.model.Tarea;
import com.example.tareas.repository.TareaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TareaService {

    private final TareaRepository tareaRepository;

    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public List<Tarea> listarTodas() {
        return tareaRepository.findAll();
    }

    public Tarea buscarPorId(Long id) {
        return tareaRepository.findById(id)
                .orElseThrow(() -> new TareaNotFoundException("Tarea " + id + " no encontrada"));
    }

    public Tarea crear(Tarea tarea) {
        tarea.setEstado(EstadoTarea.PENDIENTE);
        return tareaRepository.save(tarea);
    }

    public Tarea cambiarEstado(Long id, EstadoTarea nuevoEstado) {
        Tarea tarea = buscarPorId(id);
        tarea.setEstado(nuevoEstado);
        return tareaRepository.save(tarea);
    }

    public void eliminar(Long id) {
        buscarPorId(id);
        tareaRepository.deleteById(id);
    }
}
