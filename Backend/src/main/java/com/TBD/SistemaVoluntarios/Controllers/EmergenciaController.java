package com.TBD.SistemaVoluntarios.Controllers;

import com.TBD.SistemaVoluntarios.Entities.EmergenciaEntity;
import com.TBD.SistemaVoluntarios.Repositories.EmergenciaRepository;
import com.TBD.SistemaVoluntarios.RepositoriesImplement.EmergenciaRepoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/emergencia")
public class EmergenciaController {

    private final EmergenciaRepository emergenciaRepository;

    EmergenciaController(EmergenciaRepository EmergenciaRepository){
        this.emergenciaRepository = EmergenciaRepository;
    }


    @GetMapping("/lista-emergencia")
    public ResponseEntity<List<EmergenciaEntity>> listar(Model model)
    {
        return ResponseEntity.ok(emergenciaRepository.findAll());
    }


}
