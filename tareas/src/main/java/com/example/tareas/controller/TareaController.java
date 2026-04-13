package com.example.tareas.controller;

import com.example.tareas.domain.model.EstadoTarea;
import com.example.tareas.domain.model.Tarea;
import com.example.tareas.service.TareaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    private final TareaService tareaService;

    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @GetMapping
    public List<Tarea> listar() {
        return tareaService.listarTodas();
    }

    @GetMapping("/{id}")
    public Tarea buscar(@PathVariable Long id) {
        return tareaService.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tarea crear(@Valid @RequestBody Tarea tarea) {
        return tareaService.crear(tarea);
    }

    @PatchMapping("/{id}/estado")
    public Tarea cambiarEstado(@PathVariable Long id, @RequestParam EstadoTarea estado) {
        return tareaService.cambiarEstado(id, estado);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        tareaService.eliminar(id);
    }
}
