package com.TBD.SistemaVoluntarios.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
CREATE TABLE eme_habilidad(
        ID_EME_HAB NUMERIC(8) PRIMARY KEY,
        ID_EMERGENCIA NUMERIC(6),
        ID_HABILIDAD NUMERIC(4)
        );
*/
@Entity
@Table(name="eme_habilidad")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmeHabilidadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer ID_EME_HAB;
    Integer ID_EMERGENCA;
    Integer ID_HABILIDAD;
}
