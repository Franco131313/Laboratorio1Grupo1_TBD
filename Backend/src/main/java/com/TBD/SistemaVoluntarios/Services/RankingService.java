package com.TBD.SistemaVoluntarios.Services;

import com.TBD.SistemaVoluntarios.Entities.RankingEntity;
import com.TBD.SistemaVoluntarios.Repositories.RankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RankingService {
    @Autowired
    RankingRepository rankingRepository;

    public ArrayList<RankingEntity> rankingCompleto()
    {
        return rankingRepository.findAll();
    }

    public void nuevo(Integer idVol, Integer idTar, Integer puntos, Integer invitado, Integer participa)
    {
        RankingEntity nuevo = new RankingEntity();
        nuevo.setID_VOLUNTARIO(idVol);
        nuevo.setID_TAREA(idTar);
        nuevo.setPuntaje(puntos);
        nuevo.setFlg_invitado(invitado);
        nuevo.setFlg_participa(participa);
        rankingRepository.save(nuevo);
    }

    public void eliminar(RankingEntity rank)
    {
        rankingRepository.delete(rank);
    }
}
