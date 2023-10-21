package com.TBD.SistemaVoluntarios.Repositories;



import com.TBD.SistemaVoluntarios.Entities.VolHabilidadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

public interface VolHabilidadRepository{
    ArrayList<VolHabilidadEntity> findAll();

}
