package com.taskify.demo.Repository;

import com.taskify.demo.Entity.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository extends JpaRepository<Tarea, Long> {
}