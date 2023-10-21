package com.TBD.SistemaVoluntarios.RepositoriesImplement;

import com.TBD.SistemaVoluntarios.Entities.RankingEntity;
import com.TBD.SistemaVoluntarios.Repositories.RankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.List;

@Service
public class RankingRepoImp implements RankingRepository{
    @Autowired
    Sql2o sql2o;

    @Override
    public List<RankingEntity> findAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Ranking order by id")
                    .executeAndFetch(RankingEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
