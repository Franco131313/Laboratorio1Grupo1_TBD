package com.TBD.SistemaVoluntarios.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Entity
@Table(name="voluntario")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class VoluntarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_VOLUNTARIO;

    private Integer ID_USUARIO;
    private String nombre;

    //Cuidar formato WGS84, el cual establece
    //que las coordenadas son angulares.
    private Float latitud;
    private Float longitud;
}
