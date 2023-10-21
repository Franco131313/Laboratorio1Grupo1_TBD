package com.TBD.SistemaVoluntarios.Repositories;



import com.TBD.SistemaVoluntarios.Entities.EmergenciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface EmergenciaRepository extends JpaRepository<EmergenciaEntity, Integer>{

    ArrayList<EmergenciaEntity> findAll();
}
