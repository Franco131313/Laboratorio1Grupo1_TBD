package com.TBD.SistemaVoluntarios.Controllers;

import com.TBD.SistemaVoluntarios.Entities.EmergenciaEntity;
import com.TBD.SistemaVoluntarios.Services.EmergenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
@RestController
@RequestMapping("/emergencia")
public class EmergenciaController {
    @Autowired
    EmergenciaService emergenciaService;

    @GetMapping("lista-emergencia")
    public ResponseEntity<ArrayList<EmergenciaEntity>> listar(Model model)
    {
        ArrayList<EmergenciaEntity> emergenciaEntities = emergenciaService.todos();
        model.addAttribute("emergencias", emergenciaEntities);
        return ResponseEntity.ok(emergenciaEntities);
    }


}
