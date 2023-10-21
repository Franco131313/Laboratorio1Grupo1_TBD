package com.TBD.SistemaVoluntarios.Controllers;

import com.TBD.SistemaVoluntarios.Entities.VoluntarioEntity;
import com.TBD.SistemaVoluntarios.Repositories.VoluntarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/voluntario")
public class VoluntarioController {
    private final VoluntarioRepository voluntarioRepository;

    public VoluntarioController(VoluntarioRepository voluntarioRepository) {
        this.voluntarioRepository = voluntarioRepository;
    }

    @GetMapping("/lista-voluntarios")
    public ResponseEntity<List<VoluntarioEntity>> listar(Model model) {

        return ResponseEntity.ok(voluntarioRepository.findAll());
    }
}
