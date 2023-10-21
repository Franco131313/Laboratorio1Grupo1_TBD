package com.TBD.SistemaVoluntarios.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CREATE TABLE usuario(
 * 	ID_USUARIO INTEGER PRIMARY KEY,
 * 	email VARCHAR(100),
 * 	password VARCHAR(100),
 * 	rol VARCHAR(50)
 * );
 */
@Entity
@Table(name="usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer ID_USUARIO;
    private String email;
    private String password;
    private String rol;
}
