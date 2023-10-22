package com.TBD.SistemaVoluntarios.Controllers;

import com.TBD.SistemaVoluntarios.Entities.HabilidadEntity;
import com.TBD.SistemaVoluntarios.Entities.InstitucionEntity;
import com.TBD.SistemaVoluntarios.Repositories.InstitucionRepository;
import com.TBD.SistemaVoluntarios.RepositoriesImplement.InstitucionRepoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/institucion")
public class InstitucionController {

    private final InstitucionRepository institucionRepository;

    InstitucionController(InstitucionRepository InstitucionRepository){
        this.institucionRepository = InstitucionRepository;
    }

    // CREATE: crear una nueva institucion.
    @PostMapping("/nueva-institucion")
    public ResponseEntity<String> createInstitucion(@RequestBody InstitucionEntity institucion)
    {
        institucionRepository.createInstitucion(institucion);
        return ResponseEntity.ok("Institucion creada con exito");
    }

    // READ: Listar todas las instituciones.
    @GetMapping("/lista-institucion")
    public ResponseEntity<List<InstitucionEntity>> listar(Model model)
    {
        return ResponseEntity.ok(institucionRepository.findAll());
    }
    // UPDATE: Actualiza la descripcion de una institucion.
    @PutMapping("/{id}")
    public ResponseEntity<String> updateDesc(@PathVariable Integer id,
                                             @RequestParam("descrip") String descrip)
    {
        institucionRepository.updateDescrip(id, descrip);
        return ResponseEntity.ok("Descripcion de la institucion actualizada con exito");
    }

    // DELETE: Elimina una institucion.
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEm(@PathVariable Integer id)
    {
        institucionRepository.deleteById(id);
        return ResponseEntity.ok("Institucion eliminada exitosamente");
    }

}
