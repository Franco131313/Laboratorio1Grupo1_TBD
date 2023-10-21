package com.TBD.SistemaVoluntarios.Repositories;


import com.TBD.SistemaVoluntarios.Entities.HabilidadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface HabilidadRepository extends JpaRepository<HabilidadEntity, Integer>{
    ArrayList<HabilidadEntity> findAll();

}
