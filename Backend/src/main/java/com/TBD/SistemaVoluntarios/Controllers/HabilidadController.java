package com.TBD.SistemaVoluntarios.Controllers;

import com.TBD.SistemaVoluntarios.Entities.HabilidadEntity;
import com.TBD.SistemaVoluntarios.Repositories.HabilidadRepository;
import com.TBD.SistemaVoluntarios.RepositoriesImplement.HabilidadRepoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/habilidad")
public class HabilidadController {

    private final HabilidadRepository habilidadRepository;

    HabilidadController(HabilidadRepository HabilidadRepository){
        this.habilidadRepository = HabilidadRepository;
    }


    @GetMapping("/lista-habilidad")
    public ResponseEntity<List<HabilidadEntity>> listar(Model model)
    {
        return ResponseEntity.ok(habilidadRepository.findAll());
    }
}
