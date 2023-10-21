package com.TBD.SistemaVoluntarios.Controllers;

import com.TBD.SistemaVoluntarios.Entities.EmeHabilidadEntity;
import com.TBD.SistemaVoluntarios.Repositories.EmeHabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/emeHabilidad")
public class EmeHabilidadController {

    EmeHabilidadRepository emeHabilidadRepository;

    EmeHabilidadController(EmeHabilidadRepository EmeHabilidadRepository){
        this.emeHabilidadRepository = EmeHabilidadRepository;
    }


    @GetMapping("/lista-emeHabilidad")
    public ResponseEntity<List<EmeHabilidadEntity>> listar(Model model)
    {
        return ResponseEntity.ok(emeHabilidadRepository.findAll());
    }
}
