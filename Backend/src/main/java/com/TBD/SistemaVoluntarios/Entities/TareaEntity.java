package com.TBD.SistemaVoluntarios.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * CREATE TABLE tarea(
 * 	ID_TAREA NUMERIC(8) PRIMARY KEY,
 * 	nombre VARCHAR(60),
 * 	descrip VARCHAR(300),
 * 	fecha_inicio DATE,
 * 	fecha_fin DATE,
 * 	cant_vol_requeridos NUMERIC(4),
 * 	cant_vol_inscritos NUMERIC(4),
 * 	ID_EMERGENCIA NUMERIC(6),
 * 	ID_ESTADO NUMERIC(2)
 * );
 */
@Entity
@Table(name="tarea")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class TareaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_TAREA;
    private String nombre;
    private String descrip;
    private Date fecha_inicio;
    private Date fecha_fin;
    private Integer ID_EMERGENCIA;
    private Integer ID_ESTADO;
}
