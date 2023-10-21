package com.TBD.SistemaVoluntarios.Repositories;


import com.TBD.SistemaVoluntarios.Entities.TareaHabilidadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
public interface TareaHabilidadRepository{
    ArrayList<TareaHabilidadEntity> findAll();
}
