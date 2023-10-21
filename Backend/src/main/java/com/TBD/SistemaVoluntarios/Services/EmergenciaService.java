package com.TBD.SistemaVoluntarios.Services;

import com.TBD.SistemaVoluntarios.Entities.EmergenciaEntity;
import com.TBD.SistemaVoluntarios.Repositories.EmergenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class EmergenciaService {
    @Autowired
    EmergenciaRepository emergenciaRepository;

    public ArrayList<EmergenciaEntity> todos()
    {
        return emergenciaRepository.findAll();
    }
}
