package com.TBD.SistemaVoluntarios.Repositories;



import com.TBD.SistemaVoluntarios.Entities.EmergenciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public interface EmergenciaRepository{

    List<EmergenciaEntity> findAll();
}
