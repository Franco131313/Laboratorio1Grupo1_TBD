package com.TBD.SistemaVoluntarios.Controllers;

import com.TBD.SistemaVoluntarios.Entities.RankingEntity;
import com.TBD.SistemaVoluntarios.Services.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/rank")
public class RankingController {
    @Autowired
    RankingService rankingService;


    @GetMapping("lista")
    public ResponseEntity<ArrayList<RankingEntity>> listar(Model model)
    {
        ArrayList<RankingEntity> ranks = rankingService.rankingCompleto();
        model.addAttribute("ranks", ranks);
        return ResponseEntity.ok(ranks);
    }

}
