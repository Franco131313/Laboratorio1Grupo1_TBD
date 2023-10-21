package com.TBD.SistemaVoluntarios.Controllers;

import com.TBD.SistemaVoluntarios.Entities.InstitucionEntity;
import com.TBD.SistemaVoluntarios.Services.InstitucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/institucion")
public class InstitucionController {
    @Autowired
    InstitucionService institucionService;

    @GetMapping("lista-institucion")
    public ResponseEntity<ArrayList<InstitucionEntity>> listar(Model model)
    {
        ArrayList<InstitucionEntity> institucionEntities = institucionService.todos();
        model.addAttribute("instituciones", institucionEntities);
        return ResponseEntity.ok(institucionEntities);
    }

}
