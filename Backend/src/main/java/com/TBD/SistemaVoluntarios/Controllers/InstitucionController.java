package com.TBD.SistemaVoluntarios.Controllers;

import com.TBD.SistemaVoluntarios.Entities.InstitucionEntity;
import com.TBD.SistemaVoluntarios.Repositories.InstitucionRepository;
import com.TBD.SistemaVoluntarios.RepositoriesImplement.InstitucionRepoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/institucion")
public class InstitucionController {

    private final InstitucionRepository institucionRepository;

    InstitucionController(InstitucionRepository InstitucionRepository){
        this.institucionRepository = InstitucionRepository;
    }

    @GetMapping("/lista-institucion")
    public ResponseEntity<List<InstitucionEntity>> listar(Model model)
    {
        return ResponseEntity.ok(institucionRepository.findAll());
    }

}
