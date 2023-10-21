package com.TBD.SistemaVoluntarios.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * CREATE TABLE ranking(
 * 	ID_RANKING NUMERIC(8) PRIMARY KEY,
 * 	ID_VOLUNTARIO NUMERIC(8),
 * 	ID_TAREA NUMERIC(8),
 * 	puntaje NUMERIC(3,2),
 * 	flg_invitado NUMERIC(1),
 * 	flg_participa NUMERIC(1)
 * );
 *
 */
@Entity
@Table(name="ranking")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RankingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer ID_RANKING;
    Integer ID_VOLUNTARIO;
    Integer ID_TAREA;
    Integer puntaje;
    Integer flg_invitado;
    Integer flg_participa;
}
