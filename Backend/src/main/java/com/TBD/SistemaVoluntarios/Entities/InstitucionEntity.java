package com.TBD.SistemaVoluntarios.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CREATE TABLE institucion(
 * 	ID_INSTITUCION NUMERIC(4) PRIMARY KEY,
 * 	nombre VARCHAR(100),
 * 	descrip VARCHAR(400)
 * );
 */
@Entity
@Table(name="institucion")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class InstitucionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer ID_INSTITUCION;
    private String nombre;
    private  String descrip;
}
