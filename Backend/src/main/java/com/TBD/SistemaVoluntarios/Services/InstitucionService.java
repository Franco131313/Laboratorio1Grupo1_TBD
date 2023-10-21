package com.TBD.SistemaVoluntarios.Services;

import com.TBD.SistemaVoluntarios.Entities.InstitucionEntity;
import com.TBD.SistemaVoluntarios.Repositories.InstitucionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class InstitucionService {
    @Autowired
    InstitucionRepository institucionRepository;

    public ArrayList<InstitucionEntity> todos()
    {
        return institucionRepository.findAll();
    }
}
