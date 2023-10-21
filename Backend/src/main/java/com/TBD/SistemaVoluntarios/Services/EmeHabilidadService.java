package com.TBD.SistemaVoluntarios.Services;

import com.TBD.SistemaVoluntarios.Entities.EmeHabilidadEntity;
import com.TBD.SistemaVoluntarios.Repositories.EmeHabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmeHabilidadService {
    @Autowired
    EmeHabilidadRepository emeHabilidadRepository;

    public ArrayList<EmeHabilidadEntity> todos()
    {
        return emeHabilidadRepository.findAll();
    }
}
