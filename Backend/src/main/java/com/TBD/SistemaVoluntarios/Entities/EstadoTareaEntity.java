package com.TBD.SistemaVoluntarios.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CREATE TABLE estado_tarea(
 * 	ID_ESTADO NUMERIC(2) PRIMARY KEY,
 * 	descrip VARCHAR(20)
 * );
 */
@Entity
@Table(name="estado_tarea")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class EstadoTareaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_ESTADO;
    private String descripcion;
}
