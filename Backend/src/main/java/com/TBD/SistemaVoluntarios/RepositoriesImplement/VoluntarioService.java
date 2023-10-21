package com.TBD.SistemaVoluntarios.RepositoriesImplement;

import com.TBD.SistemaVoluntarios.Entities.VoluntarioEntity;
import com.TBD.SistemaVoluntarios.Repositories.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Sql2o;

import java.util.ArrayList;

@Service
public class VoluntarioService {
    @Autowired
    private VoluntarioRepository voluntarioRepository;


    @Autowired
    public VoluntarioService(Sql2o sql2o) {
    }

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
