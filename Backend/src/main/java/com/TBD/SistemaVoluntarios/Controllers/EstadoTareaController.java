package com.TBD.SistemaVoluntarios.Controllers;

import com.TBD.SistemaVoluntarios.Entities.EstadoTareaEntity;
import com.TBD.SistemaVoluntarios.Services.EstadoTareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/estadoTarea")
public class EstadoTareaController {
    @Autowired
    EstadoTareaService estadoTareaService;

    @GetMapping("lista-estadoTarea")
    public ResponseEntity<ArrayList<EstadoTareaEntity>> listar(Model model)
    {
        ArrayList<EstadoTareaEntity> estadoTareaEntities = estadoTareaService.todos();
        model.addAttribute("estadoTareas", estadoTareaEntities);
        return ResponseEntity.ok(estadoTareaEntities);
    }
}
