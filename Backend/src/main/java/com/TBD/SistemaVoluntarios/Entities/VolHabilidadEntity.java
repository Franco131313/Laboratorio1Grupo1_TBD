package com.TBD.SistemaVoluntarios.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CREATE TABLE vol_habilidad(
 * 	ID_VOL_HAB NUMERIC(8) PRIMARY KEY,
 * 	ID_VOLUNTARIO NUMERIC(8),
 * 	ID_HABILIDAD NUMERIC(8)
 * );
 */

@Entity
@Table(name="vol_habilidad")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class VolHabilidadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer ID_VOL_HAB;
    private  Integer ID_VOLUNTARIO;
    private  Integer ID_HABILIDAD;
}
