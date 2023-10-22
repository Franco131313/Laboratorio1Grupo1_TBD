package com.TBD.SistemaVoluntarios.Controllers;

import com.TBD.SistemaVoluntarios.Entities.RankingEntity;
import com.TBD.SistemaVoluntarios.Repositories.RankingRepository;
import com.TBD.SistemaVoluntarios.RepositoriesImplement.RankingRepoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/rankings")
public class RankingController {
    private final RankingRepoImp rankingRepoImp;
    @Autowired
    public RankingController(RankingRepoImp rankingRepoImpepoimp)
    {
        this.rankingRepoImp = rankingRepoImpepoimp;
    }

    // CREATE: crear un nuevo ranking.
    @PostMapping("/agregar-ranking")
    public ResponseEntity<String> crearRanking(RankingEntity ranking)
    {
        rankingRepoImp.createRanking(ranking);
        return ResponseEntity.ok("Ranking creado con exito");
    }

    // READ: leer todos los rankings.
    @GetMapping("/lista-rankings")
    public ResponseEntity<List<RankingEntity>> leerTodoElRanking()
    {
        List<RankingEntity> rankings = rankingRepoImp.leerTodoElRanking();
        return ResponseEntity.ok(rankings);
    }

    // READ: leer un ranking por ID.
    @GetMapping("/{id}")
    public ResponseEntity<RankingEntity> leerRankingPorId(Integer id)
    {
        RankingEntity ranking = rankingRepoImp.leerRankingPorId(id);
        return ResponseEntity.ok(ranking);
    }

    // UPDATE: actualiza el puntaje de un ranking, en base a un ID.
    @PutMapping("/id")
    public ResponseEntity<String> actualizarPuntaje(Integer id, @RequestParam("nuevoPuntaje") Integer nuevoPuntaje)
    {
        rankingRepoImp.actualizarPuntaje(id, nuevoPuntaje);
        return ResponseEntity.ok("Puntaje actualizado con exito.");
    }

    // DELETE: eliminar un ranking por ID.
    @DeleteMapping("/id")
    public ResponseEntity<String> eliminarRankingPorId(Integer id)
    {
        rankingRepoImp.eliminarRankingPorId(id);
        return ResponseEntity.ok("Ranking eliminado exitosamente.");
    }

}
