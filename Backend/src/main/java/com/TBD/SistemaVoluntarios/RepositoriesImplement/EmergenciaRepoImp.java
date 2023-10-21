package com.TBD.SistemaVoluntarios.RepositoriesImplement;

import com.TBD.SistemaVoluntarios.Entities.EmergenciaEntity;
import com.TBD.SistemaVoluntarios.Repositories.EmergenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmergenciaRepoImp implements EmergenciaRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<EmergenciaEntity> findAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select id, nombre, descrip, finicio, ffin, id_institucion, " +
                            "ST_X(geom) AS longitud, ST_Y(geom) AS latitud from Emergencia order by id")
                    .executeAndFetch(EmergenciaEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
