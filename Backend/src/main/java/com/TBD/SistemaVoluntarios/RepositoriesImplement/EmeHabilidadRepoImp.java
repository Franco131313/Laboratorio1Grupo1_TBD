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

    //CREATE: Crear una nueva conexion
    @Override
    public void createEmeHabilidad(EmeHabilidadEntity emeHabilidad)
    {
        try (Connection con = sql2o.open()) {
            String sql = "INSERT INTO eme_habilidad (ID_EME_HAB, ID_EMERGENCIA, ID_HABILIDAD)" +
                    "VALUES (:ID_EME_HAB, :ID_EMERGENCIA, :ID_HABILIDAD)";
            con.createQuery(sql)
                    .addParameter("ID_EME_HAB", emeHabilidad.getID_EME_HAB())
                    .addParameter("ID_EMERGENCIA", emeHabilidad.getID_EMERGENCA())
                    .addParameter("ID_HABILIDAD", emeHabilidad.getID_HABILIDAD())
                    .executeUpdate();
        }
    }

    //READ: Buscar todas las conexiones
    @Override
    public List<EmeHabilidadEntity> findAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from eme_habilidad order by ID_EME_HAB")
                    .executeAndFetch(EmeHabilidadEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //READ: Buscar a una conexion a partir de su ID
    @Override
    public EmeHabilidadEntity findByID_EME_HAB(Integer id) {
        try (Connection conn = sql2o.open()) {
            List<EmeHabilidadEntity> emeHabilidadEntities = conn.createQuery("select * from eme_habilidad where ID_EME_HAB=:id")
                    .addParameter("ID_EME_HAB", id)
                    .executeAndFetch(EmeHabilidadEntity.class);
            return emeHabilidadEntities.get(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // DELETE: elimina una conexion por ID
    @Override
    public void deleteById(Integer id) {
        try (Connection con = sql2o.open()) {
            String sql = "DELETE FROM eme_habilidad WHERE ID_EME_HAB = :id";
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
