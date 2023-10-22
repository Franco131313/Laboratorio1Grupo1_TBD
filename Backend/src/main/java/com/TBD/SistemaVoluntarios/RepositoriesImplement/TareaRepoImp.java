package com.TBD.SistemaVoluntarios.RepositoriesImplement;

import com.TBD.SistemaVoluntarios.Entities.TareaEntity;
import com.TBD.SistemaVoluntarios.Repositories.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.List;

@Service
public class TareaRepoImp implements TareaRepository{
    @Autowired
    Sql2o sql2o;

    @Override
    public List<TareaEntity> findAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select id, nombre, descrip, cant_vol_requeridos, cant_vol_inscritos, " +
                            "id_emergencia, fecha_inicio, fecha_fin, id_estado, ST_X(geom) AS longitud, " +
                            "ST_Y(geom) AS latitud from Tarea order by id ")
                    .executeAndFetch(TareaEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
