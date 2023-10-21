package com.TBD.SistemaVoluntarios.Repositories;

import com.TBD.SistemaVoluntarios.Entities.EmeHabilidadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface EmeHabilidadRepository  extends JpaRepository<EmeHabilidadEntity, Integer> {

    ArrayList<EmeHabilidadEntity> findAll();

}
