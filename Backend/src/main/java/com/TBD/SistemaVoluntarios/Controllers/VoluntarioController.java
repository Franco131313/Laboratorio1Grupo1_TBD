package com.TBD.SistemaVoluntarios.Controllers;

import com.TBD.SistemaVoluntarios.Entities.VoluntarioEntity;
import com.TBD.SistemaVoluntarios.RepositoriesImplement.VoluntarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/voluntario")
public class VoluntarioController {
    @Autowired
    VoluntarioService voluntarioService;

    @GetMapping("/lista-voluntarios")
    public ResponseEntity<ArrayList<VoluntarioEntity>> listar(Model model) {
        ArrayList<VoluntarioEntity> voluntarioEntities = voluntarioService.todos();
        model.addAttribute("voluntarios", voluntarioEntities);
        return ResponseEntity.ok(voluntarioEntities);
    }
}
