package com.TBD.SistemaVoluntarios.RepositoriesImplement;

import com.TBD.SistemaVoluntarios.Entities.InstitucionEntity;
import com.TBD.SistemaVoluntarios.Repositories.InstitucionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InstitucionRepoImp implements InstitucionRepository {
    @Autowired
    Sql2o sql2o;

    @Override
    public List<InstitucionEntity> findAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Institucion order by id")
                    .executeAndFetch(InstitucionEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
