package com.TBD.SistemaVoluntarios.Services;

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

    public void guardarUsuario(String email, String rol)
    {
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setEmail(email);
        usuario.setRol(rol);
        usuarioRepository.save(usuario);
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
