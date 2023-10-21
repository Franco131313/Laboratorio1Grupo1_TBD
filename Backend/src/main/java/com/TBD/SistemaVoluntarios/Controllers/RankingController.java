package com.TBD.SistemaVoluntarios.Controllers;

import com.TBD.SistemaVoluntarios.Entities.RankingEntity;
import com.TBD.SistemaVoluntarios.Repositories.RankingRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/rank")
public class RankingController {
    private final RankingRepository rankingRepository;

    RankingController(RankingRepository rankingRepository){
        this.rankingRepository = rankingRepository;
    }


    @GetMapping("/lista")
    public ResponseEntity<List<RankingEntity>> listar(Model model)
    {
        return ResponseEntity.ok(rankingRepository.findAll());
    }

}
