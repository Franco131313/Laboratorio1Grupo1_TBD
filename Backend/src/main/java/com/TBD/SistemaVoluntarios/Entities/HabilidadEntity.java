package com.TBD.SistemaVoluntarios.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CREATE TABLE habilidad(
 * 	ID_HABILIDAD NUMERIC(4) PRIMARY KEY,
 * 	descrip VARCHAR(100)
 * );
 */
@Entity
@Table(name="habilidad")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class HabilidadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_HABILIDAD;
    private  String descrip;
}
