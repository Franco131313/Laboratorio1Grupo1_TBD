package com.TBD.SistemaVoluntarios.Controllers;

import com.TBD.SistemaVoluntarios.Entities.TareaHabilidadEntity;
import com.TBD.SistemaVoluntarios.Services.TareaHabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/tareaHabilidad")
public class TareaHabilidadController {
    @Autowired
    TareaHabilidadService tareaHabilidadService;

    @GetMapping("lista-tareaHabilidad")
    public ResponseEntity<ArrayList<TareaHabilidadEntity>> listar(Model model)
    {
        ArrayList<TareaHabilidadEntity> tareaHabilidadEntities = tareaHabilidadService.todos();
        model.addAttribute("tareaHabilidades", tareaHabilidadEntities);
        return ResponseEntity.ok(tareaHabilidadEntities);
    }
}
