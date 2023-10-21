package com.TBD.SistemaVoluntarios.Services;

import com.TBD.SistemaVoluntarios.Entities.TareaHabilidadEntity;
import com.TBD.SistemaVoluntarios.Repositories.TareaHabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class TareaHabilidadService {
    @Autowired
    TareaHabilidadRepository tareaHabilidadRepository;

    public ArrayList<TareaHabilidadEntity> todos()
    {
        return tareaHabilidadRepository.findAll();
    }
}
