package com.example.ViaggiAzienda.service;

import com.example.ViaggiAzienda.entities.Dipendente;
import com.example.ViaggiAzienda.entitiesDTO.DipendenteDTO;
import com.example.ViaggiAzienda.mapper.DipendenteMapper;
import com.example.ViaggiAzienda.repositories.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static com.example.ViaggiAzienda.mapper.DipendenteMapper.toEntity;

@Service
public class DipendenteService {

    @Autowired private DipendenteRepository dipendenteRepository;
    @Autowired private DipendenteMapper dipendenteMapper;

    public DipendenteDTO generaDipendente(DipendenteDTO dipendenteDTO){
        Dipendente dipendente = toEntity(dipendenteDTO);
        dipendente = dipendenteRepository.save(dipendente);
        return dipendenteMapper.toDTO(dipendente);
    }
}
