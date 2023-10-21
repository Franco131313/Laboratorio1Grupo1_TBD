package com.TBD.SistemaVoluntarios.Controllers;

import com.TBD.SistemaVoluntarios.Entities.VolHabilidadEntity;
import com.TBD.SistemaVoluntarios.Repositories.VolHabilidadRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/volHabilidad")
public class VolHabilidadController {
    private final VolHabilidadRepository volHabilidadRepository;

    public VolHabilidadController(VolHabilidadRepository volHabilidadRepository) {
        this.volHabilidadRepository = volHabilidadRepository;
    }

    @GetMapping("/lista-volHabilidad")
    public ResponseEntity<List<VolHabilidadEntity>> listar(Model model)
    {
        return ResponseEntity.ok(volHabilidadRepository.findAll());
    }
}
