package com.TBD.SistemaVoluntarios.Repositories;

import com.TBD.SistemaVoluntarios.Entities.RankingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface RankingRepository extends JpaRepository<RankingEntity, Integer> {
    ArrayList<RankingEntity> findAll();
    RankingEntity findByFlg_invitado(Integer invitado);
    RankingEntity findByID_VOLUNTARIO(Integer voluntario);
    ArrayList<RankingEntity> findByID_TAREA(Integer tarea);
}
