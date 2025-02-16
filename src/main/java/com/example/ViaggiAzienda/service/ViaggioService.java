package com.example.ViaggiAzienda.service;


import com.example.ViaggiAzienda.entities.Viaggio;
import com.example.ViaggiAzienda.entitiesDTO.ViaggioDTO;
import com.example.ViaggiAzienda.enumeration.StatoViaggio;
import com.example.ViaggiAzienda.mapper.ViaggioMapper;
import com.example.ViaggiAzienda.repositories.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ViaggioService {

    @Autowired private ViaggioRepository viaggioRepository;
    @Autowired private ViaggioMapper viaggioMapper;

    public ViaggioDTO generaViaggio(ViaggioDTO viaggioDTO){
        Viaggio viaggio = ViaggioMapper.toEntity(viaggioDTO);
        viaggio = viaggioRepository.save(viaggio);
        return  viaggioMapper.toDTO(viaggio);
    }

    public ViaggioDTO aggiornaViaggio(Long id, StatoViaggio statoViaggio){
        Optional<Viaggio> viaggioOptional = viaggioRepository.findById(id);
        Viaggio viaggio = viaggioOptional.get();
        viaggio.setStatoViaggio(statoViaggio);
        viaggio = viaggioRepository.save(viaggio);
        return viaggioMapper.toDTO(viaggio);
    }

    public List<Viaggio> prendiTuttiViaggi(){
        return viaggioRepository.findAll();
    }

    public Optional<Viaggio> prendiViaggioTramiteId(Long id){
        return viaggioRepository.findById(id);
    }

    public void rimuoviViaggioTramiteId(Long id){
        viaggioRepository.deleteAllById(Collections.singleton(id));
    }
}
