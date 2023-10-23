package com.TBD.SistemaVoluntarios.RepositoriesImplement;

import com.TBD.SistemaVoluntarios.Entities.UsuarioEntity;
import com.TBD.SistemaVoluntarios.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class UsuarioRepoImp implements UsuarioRepository{
    @Autowired
    private final Sql2o sql2o;

    public UsuarioRepoImp(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    //CREATE: Crear un nuevo usuario
    @Override
    public void createUsuario(UsuarioEntity usuario)
    {
        try (Connection con = sql2o.open()) {
            String sql = "INSERT INTO usuario (email, password, rol) " +
                    "VALUES (:usuario, :password, :rol)";
            con.createQuery(sql)
                    .addParameter("email", usuario.getEmail())
                    .addParameter("password", usuario.getPassword())
                    .addParameter("rol", usuario.getRol())
                    .executeUpdate();
        }
    }

    //READ: Buscar todos los usuarios
    @Override
    public List<UsuarioEntity> findAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from usuario order by ID_USUARIO")
                    .executeAndFetch(UsuarioEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //READ: Buscar a todos los usuarios que estén asociados a un rol determinado
    @Override
    public List<UsuarioEntity> findAllByRol(String rol) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from usuario where rol=:rol")
                    .addParameter("rol", rol)
                    .executeAndFetch(UsuarioEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //READ: Buscar a un usuario a partir de su ID
    @Override
    public UsuarioEntity findByID_USUARIO(Integer id) {
        try (Connection conn = sql2o.open()) {
            List<UsuarioEntity> usuarios = conn.createQuery("select * from usuario where ID_USUARIO=:id")
                    .addParameter("ID_USUARIO", id)
                    .executeAndFetch(UsuarioEntity.class);
            return usuarios.get(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //READ: Buscar a un usuario a partir de su e-mail
    @Override
    public UsuarioEntity findByEmail(String email) {
        try (Connection conn = sql2o.open()) {
            List<UsuarioEntity> usuarios = conn.createQuery("select * from usuario where email=:email")
                    .addParameter("email", email)
                    .executeAndFetch(UsuarioEntity.class);
            return usuarios.get(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    //UPDATE: Actualiza el Email de un usuario
    @Override
    public void updateEmail(Integer id, String nuevoEmail) {
        try (Connection con = sql2o.open()) {
            String sql = "UPDATE usuario SET email = :nuevoEmail WHERE ID_USUARIO = :id";
            con.createQuery(sql)
                    .addParameter("email", nuevoEmail)
                    .addParameter("ID_USUARIO", id)
                    .executeUpdate();
        }
    }

    //UPDATE: Actualiza el Password de un usuario
    @Override
    public void updatePass(Integer id, String nuevoPass) {
        try (Connection con = sql2o.open()) {
            String sql = "UPDATE usuario SET password = :nuevoPass WHERE ID_USUARIO = :id";
            con.createQuery(sql)
                    .addParameter("password", nuevoPass)
                    .addParameter("ID_USUARIO", id)
                    .executeUpdate();
        }
    }

    // DELETE: elimina un ranking por ID
    @Override
    public void deleteById(Integer id) {
        try (Connection con = sql2o.open()) {
            String sql = "DELETE FROM usuario WHERE ID_USUARIO = :id";
            con.createQuery(sql)
                    .addParameter("ID_USUARIO", id)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
