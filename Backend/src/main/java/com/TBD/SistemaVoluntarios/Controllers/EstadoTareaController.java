package com.TBD.SistemaVoluntarios.Controllers;

import com.TBD.SistemaVoluntarios.Entities.EstadoTareaEntity;
import com.TBD.SistemaVoluntarios.Repositories.EstadoTareaRepository;
import com.TBD.SistemaVoluntarios.RepositoriesImplement.EstadoTareaRepoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/estadoTarea")
public class EstadoTareaController {

    private final EstadoTareaRepository estadoTareaRepository;

    EstadoTareaController(EstadoTareaRepository EstadoTareaRepository){
        this.estadoTareaRepository = EstadoTareaRepository;
    }

    @GetMapping("/lista-estadoTarea")
    public ResponseEntity<List<EstadoTareaEntity>> listar(Model model)
    {
        return ResponseEntity.ok(estadoTareaRepository.findAll());
    }
}
