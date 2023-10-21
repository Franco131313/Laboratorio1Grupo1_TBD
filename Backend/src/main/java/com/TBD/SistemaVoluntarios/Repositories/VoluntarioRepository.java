package com.TBD.SistemaVoluntarios.Repositories;

import com.TBD.SistemaVoluntarios.Entities.VoluntarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

public interface VoluntarioRepository {
    ArrayList<VoluntarioEntity> findAll();

    VoluntarioEntity findByNombre(String nombre);

    VoluntarioEntity findByID_USUARIO(Integer id);
}
