package com.example.ViaggiAzienda.service;

import com.example.ViaggiAzienda.entities.Dipendente;
import com.example.ViaggiAzienda.entities.Viaggio;
import com.example.ViaggiAzienda.entitiesDTO.DipendenteDTO;
import com.example.ViaggiAzienda.mapper.DipendenteMapper;
import com.example.ViaggiAzienda.repositories.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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

    public List<Dipendente> prendiTuttiDipendenti(){
        return dipendenteRepository.findAll();
    }

    public Optional<Dipendente> prendiDipendenteTramiteId(Long id) {
        return dipendenteRepository.findById(id);
    }

    public void rimuoviDipendenteTramiteId(Long id){
        dipendenteRepository.deleteAllById(Collections.singleton(id));
    }
}
