package com.TBD.SistemaVoluntarios.RepositoriesImplement;

import com.TBD.SistemaVoluntarios.Entities.UsuarioEntity;
import com.TBD.SistemaVoluntarios.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<UsuarioEntity> todos()
    {
        return usuarioRepository.findAll();
    }
    public ArrayList<UsuarioEntity> todosPorRol(String Rol)
    {
        return usuarioRepository.findAllByRol(Rol);
    }

    public UsuarioEntity porID(Integer id)
    {
        return usuarioRepository.findByID_USUARIO(id);
    }
    public UsuarioEntity porEmail(String email)
    {
        return usuarioRepository.findByEmail(email);
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
}
