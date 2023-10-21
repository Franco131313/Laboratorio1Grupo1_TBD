package com.TBD.SistemaVoluntarios.Services;

import com.TBD.SistemaVoluntarios.Entities.EstadoTareaEntity;
import com.TBD.SistemaVoluntarios.Repositories.EstadoTareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class EstadoTareaService {
    @Autowired
    EstadoTareaRepository estadoTareaRepository;

    public ArrayList<EstadoTareaEntity> todos()
    {
        return estadoTareaRepository.findAll();
    }
}
