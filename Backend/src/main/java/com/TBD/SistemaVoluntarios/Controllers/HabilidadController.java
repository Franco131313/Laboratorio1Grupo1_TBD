package com.TBD.SistemaVoluntarios.Controllers;

import com.TBD.SistemaVoluntarios.Entities.HabilidadEntity;
import com.TBD.SistemaVoluntarios.Services.HabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/habilidad")
public class HabilidadController {
    @Autowired
    HabilidadService habilidadService;

    @GetMapping("lista-habilidad")
    public ResponseEntity<ArrayList<HabilidadEntity>> listar(Model model)
    {
        ArrayList<HabilidadEntity> habilidadEntities = habilidadService.todos();
        model.addAttribute("habilidades", habilidadEntities);
        return ResponseEntity.ok(habilidadEntities);
    }
}
