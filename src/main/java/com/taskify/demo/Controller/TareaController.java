package com.taskify.demo.Controller;

import com.taskify.demo.Entity.Tarea;
import com.taskify.demo.Service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {
    private final TareaService tareaService;

    @Autowired
    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @GetMapping
    public List<Tarea> getAllTareas() {
        return tareaService.getAllTareas();
    }

    @GetMapping("/{id}")
    public Tarea getTareaById(@PathVariable Long id) {
        return tareaService.getTareaById(id).orElse(null);
    }

    @PostMapping
    public Tarea crearTarea(@RequestBody Tarea tarea) {
        tarea.setCreadoEn(LocalDateTime.now());
        tarea.setActualizadoEn(LocalDateTime.now());
        return tareaService.saveTarea(tarea);
    }

    @PutMapping("/{id}")
    public Tarea actualizarTarea(@PathVariable Long id, @RequestBody Tarea tarea) {
        Tarea tareaExistente = tareaService.getTareaById(id).orElse(null);
        if (tareaExistente != null) {
            tareaExistente.setTitulo(tarea.getTitulo());
            tareaExistente.setDescripcion(tarea.getDescripcion());
            tareaExistente.setActualizadoEn(LocalDateTime.now());
            return tareaService.saveTarea(tareaExistente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminarTarea(@PathVariable Long id) {
        tareaService.deleteTarea(id);
    }
}
