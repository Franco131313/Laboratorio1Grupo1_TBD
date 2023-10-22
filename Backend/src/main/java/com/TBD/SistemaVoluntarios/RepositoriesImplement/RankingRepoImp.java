package com.TBD.SistemaVoluntarios.RepositoriesImplement;

import com.TBD.SistemaVoluntarios.Entities.RankingEntity;
import com.TBD.SistemaVoluntarios.Repositories.RankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RankingRepoImp {

    private final Sql2o sql2o;

    public RankingRepoImp(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    // CREATE: crear un nuevo ranking en la bd
    public void createRanking(RankingEntity ranking)
    {
        try (Connection con = sql2o.open()) {
            String sql = "INSERT INTO ranking (ID_VOLUNTARIO, ID_TAREA, puntaje, flg_invitado, flg_participa) " +
                    "VALUES (:voluntarioId, :tareaId, :puntaje, :flgInvitado, :flgParticipa)";
            con.createQuery(sql)
                    .addParameter("voluntarioId", ranking.getID_VOLUNTARIO())
                    .addParameter("tareaId", ranking.getID_TAREA())
                    .addParameter("puntaje", ranking.getPuntaje())
                    .addParameter("flgInvitado", ranking.getFlg_invitado())
                    .addParameter("flgParticipa", ranking.getFlg_participa())
                    .executeUpdate();
        }
    }

    // READ: Obtener todos los rankings
    public List<RankingEntity> leerTodoElRanking() {
        try (Connection con = sql2o.open()) {
            String sql = "SELECT * FROM ranking";
            return con.createQuery(sql).executeAndFetch(RankingEntity.class);
        }
    }

    // READ: leer ranking por ID
    public RankingEntity leerRankingPorId(Integer id) {
        try (Connection con = sql2o.open()) {
            String sql = "SELECT * FROM ranking WHERE ID_RANKING = :id";
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(RankingEntity.class);
        }
    }

    // UPDATE: actualiza el puntaje de un ranking, en base a un ID.
    public void actualizarPuntaje(Integer id, Integer nuevoPuntaje) {
        try (Connection con = sql2o.open()) {
            String sql = "UPDATE ranking SET puntaje = :nuevoPuntaje WHERE ID_RANKING = :id";
            con.createQuery(sql)
                    .addParameter("nuevoPuntaje", nuevoPuntaje)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }

    // DELETE: elimina un ranking por ID
    public void eliminarRankingPorId(Integer id) {
        try (Connection con = sql2o.open()) {
            String sql = "DELETE FROM ranking WHERE ID_RANKING = :id";
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }
}
