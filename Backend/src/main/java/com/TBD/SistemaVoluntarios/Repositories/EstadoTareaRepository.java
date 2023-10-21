package com.TBD.SistemaVoluntarios.Repositories;


import com.TBD.SistemaVoluntarios.Entities.EstadoTareaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface EstadoTareaRepository extends JpaRepository<EstadoTareaEntity, Integer>{
    ArrayList<EstadoTareaEntity> findAll();
}
