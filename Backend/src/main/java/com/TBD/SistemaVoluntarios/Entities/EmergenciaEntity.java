package com.TBD.SistemaVoluntarios.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


/**
 * CREATE TABLE emergencia(
 * 	ID_EMERGENCIA NUMERIC(6) PRIMARY KEY,
 * 	nombre VARCHAR(100),
 * 	descrip VARCHAR(400),
 * 	fecha_inicio DATE,
 * 	fecha_fin DATE,
 * 	ID_INSTITUCION NUMERIC(4),
 * 	ubi_emer GEOMETRY(Point, 4326)
 * );
 */
@Entity
@Table(name="emergencia")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class EmergenciaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_EMERGENCIA;
    private String nombre;
    private String descripcion;
    private Date fecha_inicio;
    private Date fecha_fin;
    private Integer ID_INSTITUCION;
    private Float latitud_emer;
    private Float longitud_emer;
}
