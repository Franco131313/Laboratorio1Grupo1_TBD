package com.TBD.SistemaVoluntarios.Services;

import com.TBD.SistemaVoluntarios.Entities.HabilidadEntity;
import com.TBD.SistemaVoluntarios.Repositories.HabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class HabilidadService {
    @Autowired
    HabilidadRepository habilidadRepository;

    public ArrayList<HabilidadEntity> todos()
    {
        return habilidadRepository.findAll();
    }
}
