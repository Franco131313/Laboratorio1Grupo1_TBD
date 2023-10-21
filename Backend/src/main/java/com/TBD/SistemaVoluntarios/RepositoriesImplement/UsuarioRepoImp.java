package com.TBD.SistemaVoluntarios.RepositoriesImplement;

import com.TBD.SistemaVoluntarios.Entities.UsuarioEntity;
import com.TBD.SistemaVoluntarios.Repositories.UsuarioRepository;
import org.hibernate.query.SelectionQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Service
public class UsuarioRepoImp implements UsuarioRepository{
    @Autowired
    Sql2o sql2o;
    /*
    public UsuarioEntity porID(Integer id)
    {
        return usuarioRepository.findByID_USUARIO(id);
    }
    public String guardarUsuario(String email, String pass, String rol)
    {
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setEmail(email);
        usuario.setPassword(pass);
        usuario.setRol(rol);
        usuarioRepository.save(usuario);
        usuario.setID_USUARIO(usuarioRepository.findByEmail(email).getID_USUARIO());
        if(usuarioRepository.findByEmail(email) == usuario)
        {
            return "Exito";
        }
        else {
            return "Fracaso";
        }

    }

    public void eliminarUsuarioPorEmail(String email)
    {
        UsuarioEntity usuario = usuarioRepository.findByEmail(email);
        usuarioRepository.delete(usuario);
    }
    public String rolPorID(Integer id)
    {
        UsuarioEntity usuario = usuarioRepository.findByID_USUARIO(id);
        return usuario.getRol();
    }

     */
    @Override
    public List<UsuarioEntity> findAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from Usuario order by id")
                    .executeAndFetch(UsuarioEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<UsuarioEntity> findAllByRol(String rol) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from Usuario where rol=:rol")
                    .addParameter("rol", rol)
                    .executeAndFetch(UsuarioEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public UsuarioEntity findByID_USUARIO(Integer id) {
        try (Connection conn = sql2o.open()) {
            List<UsuarioEntity> usuarios = conn.createQuery("select * from Usuario where ID_USUARIO=:id")
                    .addParameter("ID_USUARIO", id)
                    .executeAndFetch(UsuarioEntity.class);
            return usuarios.get(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public UsuarioEntity findByEmail(String email) {
        try (Connection conn = sql2o.open()) {
            List<UsuarioEntity> usuarios = conn.createQuery("select * from Usuario where email=:email")
                    .addParameter("email", email)
                    .executeAndFetch(UsuarioEntity.class);
            return usuarios.get(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
