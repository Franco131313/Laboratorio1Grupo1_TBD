package com.TBD.SistemaVoluntarios.Repositories;

import com.TBD.SistemaVoluntarios.Entities.VoluntarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public interface VoluntarioRepository {
    List<VoluntarioEntity> findAll();

    VoluntarioEntity findByNombre(String nombre);

    VoluntarioEntity findByID_USUARIO(Integer id);
}
