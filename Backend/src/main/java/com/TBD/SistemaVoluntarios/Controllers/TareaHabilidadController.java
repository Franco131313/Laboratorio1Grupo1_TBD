package com.TBD.SistemaVoluntarios.Controllers;

import com.TBD.SistemaVoluntarios.Entities.TareaHabilidadEntity;
import com.TBD.SistemaVoluntarios.Repositories.TareaHabilidadRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/tareaHabilidad")
public class TareaHabilidadController {
    private final TareaHabilidadRepository tareaHabilidadRepository;

    public TareaHabilidadController(TareaHabilidadRepository tareaHabilidadRepository) {
        this.tareaHabilidadRepository = tareaHabilidadRepository;
    }

    @GetMapping("lista-tareaHabilidad")
    public ResponseEntity<List<TareaHabilidadEntity>> listar(Model model)
    {
        return ResponseEntity.ok(tareaHabilidadRepository.findAll());
    }
}
