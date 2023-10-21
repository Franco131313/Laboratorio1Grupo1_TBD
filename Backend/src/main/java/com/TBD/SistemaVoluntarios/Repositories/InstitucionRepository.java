package com.TBD.SistemaVoluntarios.Repositories;

import com.TBD.SistemaVoluntarios.Entities.InstitucionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface InstitucionRepository extends JpaRepository<InstitucionEntity, Integer>{
    ArrayList<InstitucionEntity> findAll();
}
