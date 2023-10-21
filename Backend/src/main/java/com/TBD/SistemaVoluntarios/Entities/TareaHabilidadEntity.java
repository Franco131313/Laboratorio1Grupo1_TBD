package com.TBD.SistemaVoluntarios.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CREATE TABLE tarea_habilidad(
 * 	ID_TARHAB NUMERIC(8) PRIMARY KEY,
 * 	ID_EME_HAB NUMERIC(8),
 * 	ID_TAREA NUMERIC(8)
 * );
 */
@Entity
@Table(name="tarea_habilidad")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class TareaHabilidadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_TARHAB;
    private Integer ID_EME_HAB;
    private Integer ID_TAREA;
}
