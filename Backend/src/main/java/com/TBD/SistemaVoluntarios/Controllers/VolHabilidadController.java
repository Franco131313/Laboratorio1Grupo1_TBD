package com.TBD.SistemaVoluntarios.Controllers;

import com.TBD.SistemaVoluntarios.Entities.VolHabilidadEntity;
import com.TBD.SistemaVoluntarios.RepositoriesImplement.VolHabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/volHabilidad")
public class VolHabilidadController {
    @Autowired
    VolHabilidadService volHabilidadService;

    @GetMapping("lista-volHabilidad")
    public ResponseEntity<ArrayList<VolHabilidadEntity>> listar(Model model)
    {
        ArrayList<VolHabilidadEntity> volHabilidadEntities = volHabilidadService.todos();
        model.addAttribute("volHabilidades", volHabilidadEntities);
        return ResponseEntity.ok(volHabilidadEntities);
    }
}
