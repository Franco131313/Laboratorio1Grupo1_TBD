package com.TBD.SistemaVoluntarios.Services;

import com.TBD.SistemaVoluntarios.Entities.VolHabilidadEntity;
import com.TBD.SistemaVoluntarios.Repositories.VolHabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class VolHabilidadService {
    @Autowired
    VolHabilidadRepository volHabilidadRepository;

    public ArrayList<VolHabilidadEntity> todos()
    {
        return volHabilidadRepository.findAll();
    }
}
