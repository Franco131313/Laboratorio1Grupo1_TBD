package com.TBD.SistemaVoluntarios.RepositoriesImplement;

import com.TBD.SistemaVoluntarios.Entities.EmeHabilidadEntity;
import com.TBD.SistemaVoluntarios.Repositories.EmeHabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class EmeHabilidadRepoImp implements EmeHabilidadRepository {
    @Autowired
    Sql2o sql2o;

    @Override
    public List<EmeHabilidadEntity> findAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from eme_habilidad order by id")
                    .executeAndFetch(EmeHabilidadEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
