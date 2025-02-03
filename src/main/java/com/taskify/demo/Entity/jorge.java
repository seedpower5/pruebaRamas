package com.taskify.demo.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tareas")
public class Tarea
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String descripcion;

    private LocalDateTime creadoEn;

    private LocalDateTime actualizadoEn;

    // Constructor vacío requerido por JPA
    public Tarea() {
    }

    public Tarea(String titulo, String descripcion, LocalDateTime creadoEn, LocalDateTime actualizadoEn) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.creadoEn = creadoEn;
        this.actualizadoEn = actualizadoEn;
    }

    // Getter y Setter para cada propiedad
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(LocalDateTime creadoEn) {
        this.creadoEn = creadoEn;
    }

    public LocalDateTime getActualizadoEn() {
        return actualizadoEn;
    }

    public void setActualizadoEn(LocalDateTime actualizadoEn) {
        this.actualizadoEn = actualizadoEn;
    }
}