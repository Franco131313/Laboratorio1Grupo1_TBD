package com.TBD.SistemaVoluntarios.Services;

import com.TBD.SistemaVoluntarios.Entities.VoluntarioEntity;
import com.TBD.SistemaVoluntarios.Repositories.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class VoluntarioService {
    @Autowired
    VoluntarioRepository voluntarioRepository;

    public ArrayList<VoluntarioEntity> todos()
    {
        return voluntarioRepository.findAll();
    }

    public VoluntarioEntity porIdUser(Integer id)
    {
        return voluntarioRepository.findByID_USUARIO(id);
    }

    public void nuevoVoluntario(Integer id_user, String nombre, Float latitud, Float longitud)
    {
        VoluntarioEntity voluntario = new VoluntarioEntity();
        voluntario.setID_USUARIO(id_user);
        voluntario.setNombre(nombre);
        voluntario.setLatitud(latitud);
        voluntario.setLongitud(longitud);
        voluntarioRepository.save(voluntario);
    }
    public void eliminar(VoluntarioEntity voluntario)
    {
        voluntarioRepository.delete(voluntario);
    }
}
