package com.TBD.SistemaVoluntarios.RepositoriesImplement;

import com.TBD.SistemaVoluntarios.Entities.EmergenciaEntity;
import com.TBD.SistemaVoluntarios.Repositories.EmergenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class EmergenciaRepoImp implements EmergenciaRepository{
    @Autowired
    private Sql2o sql2o;

    //CREATE: Crear una nueva emergencia
    @Override
    public void createEmergencia(EmergenciaEntity emergencia)
    {
        try (Connection con = sql2o.open()) {
            String LonStr = Float.toString(emergencia.getLongitud_emer());
            String LatStr = Float.toString(emergencia.getLatitud_emer());
            String sql = "INSERT INTO Emergencia (ID_EMERGENCIA, nombre, descrip, fecha_inicio, fecha_fin, ID_INSTITUCION, ubi_emer)" +
                    "VALUES (:ID_EMERGENCIA, :nombre, :descrip, :fecha_inicio, :fecha_fin, :ID_INSTITUCION, ST_GeomFromText('POINT(" + LonStr + " " + LatStr + ")', 4326))";
            con.createQuery(sql)
                    .addParameter("ID_EMERGENCIA", emergencia.getID_EMERGENCIA())
                    .addParameter("nombre", emergencia.getNombre())
                    .addParameter("descrip", emergencia.getDescrip())
                    .addParameter("fecha_inicio", emergencia.getFecha_inicio())
                    .addParameter("fecha_fin", emergencia.getFecha_fin())
                    .addParameter("ID_INSTITUCION", emergencia.getID_INSTITUCION())
                    .executeUpdate();
        }
    }

    //READ: Buscar todas las emergencias
    @Override
    public List<EmergenciaEntity> findAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select ID_EMERGENCIA, nombre, descrip, fecha_inicio, fecha_fin, ID_INSTITUCION, " +
                            "ST_X(geom) AS longitud_emer, ST_Y(geom) AS latitud_emer from emergencia order by ID_EMERGENCIA")
                    .executeAndFetch(EmergenciaEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //READ: Buscar a una emergencia a partir de su ID
    @Override
    public EmergenciaEntity findByID_EMERGENCIA(Integer id) {
        try (Connection conn = sql2o.open()) {
            List<EmergenciaEntity> emergencia = conn.createQuery("select * from emergencia where ID_EMERGENCIA=:id")
                    .addParameter("ID_EMERGENCIA", id)
                    .executeAndFetch(EmergenciaEntity.class);
            return emergencia.get(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //UPDATE: Actualiza la descripción de una emergencia
    @Override
    public void updateDescrip(Integer id, String nuevaDescrip) {
        try (Connection con = sql2o.open()) {
            String sql = "UPDATE emergencia SET descrip = :nuevaDescrip WHERE ID_EMERGENCIA = :id";
            con.createQuery(sql)
                    .addParameter("descrip", nuevaDescrip)
                    .addParameter("ID_EMERGENCIA", id)
                    .executeUpdate();
        }
    }

    //UPDATE: Actualiza la institucion de una emergencia
    @Override
    public void updateInstitucion(Integer id, Integer nuevaInstitucion) {
        try (Connection con = sql2o.open()) {
            String sql = "UPDATE emergencia SET ID_INSTITUCION = :nuevaInstitucion WHERE ID_EMERGENCIA = :id";
            con.createQuery(sql)
                    .addParameter("ID_INSTITUCION", nuevaInstitucion)
                    .addParameter("ID_EMERGENCIA", id)
                    .executeUpdate();
        }
    }

    // DELETE: elimina una emergencia por ID
    @Override
    public void deleteById(Integer id) {
        try (Connection con = sql2o.open()) {
            String sql = "DELETE FROM emergencia WHERE ID_EMERGENCIA = :id";
            con.createQuery(sql)
                    .addParameter("ID_EMERGENCIA", id)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
