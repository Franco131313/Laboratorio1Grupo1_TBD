package com.TBD.SistemaVoluntarios.RepositoriesImplement;


import com.TBD.SistemaVoluntarios.Entities.VoluntarioEntity;
import com.TBD.SistemaVoluntarios.Repositories.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class VoluntarioRepoImp implements VoluntarioRepository{
    @Autowired
    Sql2o sql2o;

    //CREATE: Agregar un voluntario
    @Override
    public void agregarVoluntario(VoluntarioEntity voluntario)
    {
        try (Connection con = sql2o.open()) {
            String LonStr = Float.toString(voluntario.getLongitud());
            String LatStr = Float.toString(voluntario.getLatitud());
            String sql = "INSERT INTO voluntario (ID_USUARIO, nombre, ubi_vol)" +
                    "VALUES (:ID_USUARIO, :nombre, ST_GeomFromText('POINT(" + LonStr + " " + LatStr + ")', 4326))";
            con.createQuery(sql)
                    .addParameter("ID_USUARIO", voluntario.getID_USUARIO())
                    .addParameter("nombre", voluntario.getNombre())
                    .executeUpdate();
        }
    }

    //READ: Buscar todos los voluntarios.
    @Override
    public List<VoluntarioEntity> findAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from voluntario order by ID_VOLUNTARIO")
                    .executeAndFetch(VoluntarioEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public VoluntarioEntity findByID_USUARIO(Integer id){
        return null;
    }

    @Override
    public VoluntarioEntity findByNombre(String nombre){
        return null;
    }

    //READ: Buscar a un voluntario a partir de su ID.
    @Override
    public VoluntarioEntity findByID_VOLUNTARIO(Integer id) {
        try (Connection conn = sql2o.open()) {
            List <VoluntarioEntity> voluntario = conn.createQuery("select * from voluntario where ID_VOLUNTARIO=:id")
                    .addParameter("ID_VOLUNTARIO", id)
                    .executeAndFetch(VoluntarioEntity.class);
            return voluntario.get(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //UPDATE: Actualiza la ubicacion de un voluntario.
    @Override
    public void updateUbicacion(Integer id, float nuevaLongitud, float nuevaLatitud) {
        try (Connection con = sql2o.open()) {
            String sql = "UPDATE voluntario SET ubi_vol = ST_GeomFromText('POINT(:nuevaLongitud :nuevaLatitud)', 4326) WHERE ID_VOLUNTARIO = :id";
            con.createQuery(sql)
                    .addParameter("longitud", nuevaLongitud)
                    .addParameter("latitud", nuevaLatitud)
                    .addParameter("ID_VOLUNTARIO", id)
                    .executeUpdate();
        }
    }


    // DELETE: elimina un voluntario por ID
    @Override
    public void deleteById(Integer id) {
        try (Connection con = sql2o.open()) {
            String sql = "DELETE FROM voluntario WHERE ID_VOLUNTARIO = :id";
            con.createQuery(sql)
                    .addParameter("ID_VOLUNTARIO", id)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
