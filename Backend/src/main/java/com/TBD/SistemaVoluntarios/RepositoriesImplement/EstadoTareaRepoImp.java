package com.TBD.SistemaVoluntarios.RepositoriesImplement;

import com.TBD.SistemaVoluntarios.Entities.EstadoTareaEntity;
import com.TBD.SistemaVoluntarios.Repositories.EstadoTareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstadoTareaRepoImp implements  EstadoTareaRepository {
    @Autowired
    Sql2o sql2o;

    @Override
    public List<EstadoTareaEntity> findAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Estado_tarea order by id")
                    .executeAndFetch(EstadoTareaEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
