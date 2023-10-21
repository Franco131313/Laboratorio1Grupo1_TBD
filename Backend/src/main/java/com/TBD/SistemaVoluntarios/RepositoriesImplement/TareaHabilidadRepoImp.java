package com.TBD.SistemaVoluntarios.RepositoriesImplement;

import com.TBD.SistemaVoluntarios.Entities.TareaHabilidadEntity;
import com.TBD.SistemaVoluntarios.Repositories.TareaHabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Service
public class TareaHabilidadRepoImp implements TareaHabilidadRepository {
    @Autowired
    Sql2o sql2o;

    @Override
    public List<TareaHabilidadEntity> findAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Tarea_habilidad order by id")
                    .executeAndFetch(TareaHabilidadEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
