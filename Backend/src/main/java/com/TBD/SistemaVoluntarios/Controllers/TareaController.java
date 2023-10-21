package com.TBD.SistemaVoluntarios.Controllers;

import com.TBD.SistemaVoluntarios.Entities.TareaEntity;
import com.TBD.SistemaVoluntarios.RepositoriesImplement.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/tarea")
public class TareaController {
    @Autowired
    TareaService tareaService;

    @GetMapping("lista-tarea")
    public ResponseEntity<ArrayList<TareaEntity>> listar(Model model)
    {
        ArrayList<TareaEntity> tareaEntities = tareaService.todos();
        model.addAttribute("tareas", tareaEntities);
        return ResponseEntity.ok(tareaEntities);
    }
}
