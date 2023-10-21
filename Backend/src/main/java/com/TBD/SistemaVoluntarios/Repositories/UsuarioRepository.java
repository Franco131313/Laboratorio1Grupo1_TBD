package com.TBD.SistemaVoluntarios.Repositories;

import com.TBD.SistemaVoluntarios.Entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
    ArrayList<UsuarioEntity> findAll();
    ArrayList<UsuarioEntity> findAllByRol(String rol);
    UsuarioEntity findByID_USUARIO(Integer id);
    UsuarioEntity findByEmail(String email);

}
