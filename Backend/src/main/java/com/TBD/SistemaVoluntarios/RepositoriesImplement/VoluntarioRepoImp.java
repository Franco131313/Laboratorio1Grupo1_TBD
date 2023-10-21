package com.TBD.SistemaVoluntarios.RepositoriesImplement;

import com.TBD.SistemaVoluntarios.Entities.VoluntarioEntity;
import com.TBD.SistemaVoluntarios.Repositories.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.List;

@Service
public class VoluntarioRepoImp implements VoluntarioRepository{
    @Autowired
    Sql2o sql2o;

    /*
    public void nuevoVoluntario(Integer id_user, String nombre, Float latitud, Float longitud)
    {
        VoluntarioEntity voluntario = new VoluntarioEntity();
        voluntario.setID_USUARIO(id_user);
        voluntario.setNombre(nombre);
        voluntario.setLatitud(latitud);
        voluntario.setLongitud(longitud);
        voluntarioRepository.save(voluntario);
    }

     */

    @Override
    public List<VoluntarioEntity> findAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select id, nombre, id_usuario, ST_X(geom) AS longitud, " +
                            "ST_Y(geom) AS latitud from Voluntario order by id")
                    .executeAndFetch(VoluntarioEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public VoluntarioEntity findByNombre(String nombre) {
        try (Connection conn = sql2o.open()) {
            List<VoluntarioEntity> voluntarios = conn.createQuery("select id, nombre, id_usuario, " +
                            "ST_X(geom) AS longitud, ST_Y(geom) AS latitud from Voluntario where nombre = :nombre")
                    .addParameter("nombre", nombre)
                    .executeAndFetch(VoluntarioEntity.class);
            return voluntarios.get(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public VoluntarioEntity findByID_USUARIO(Integer id) {
        try (Connection conn = sql2o.open()) {
            List<VoluntarioEntity> voluntarios = conn.createQuery("select id, nombre, id_usuario, " +
                            "ST_X(geom) AS longitud, ST_Y(geom) AS latitud from Voluntario where id_usuario = :id")
                    .addParameter("id_usuario", id)
                    .executeAndFetch(VoluntarioEntity.class);
            return voluntarios.get(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
