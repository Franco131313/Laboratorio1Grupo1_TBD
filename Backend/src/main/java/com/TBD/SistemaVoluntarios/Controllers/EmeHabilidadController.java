package com.TBD.SistemaVoluntarios.Controllers;

import com.TBD.SistemaVoluntarios.Entities.EmeHabilidadEntity;
import com.TBD.SistemaVoluntarios.Services.EmeHabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
@RequestMapping("/emeHabilidad")
public class EmeHabilidadController {
    @Autowired
    EmeHabilidadService emeHabilidadService;

    @GetMapping("lista-emeHabilidad")
    public ResponseEntity<ArrayList<EmeHabilidadEntity>> listar(Model model)
    {
        ArrayList<EmeHabilidadEntity> emeHabilidadEntities = emeHabilidadService.todos();
        model.addAttribute("emeHabilidades", emeHabilidadEntities);
        return ResponseEntity.ok(emeHabilidadEntities);
    }
}
