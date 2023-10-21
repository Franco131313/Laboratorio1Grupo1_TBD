package com.TBD.SistemaVoluntarios.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
