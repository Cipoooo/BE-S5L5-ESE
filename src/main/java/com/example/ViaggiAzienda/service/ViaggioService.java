package com.example.ViaggiAzienda.service;


import com.example.ViaggiAzienda.entities.Viaggio;
import com.example.ViaggiAzienda.entitiesDTO.ViaggioDTO;
import com.example.ViaggiAzienda.mapper.ViaggioMapper;
import com.example.ViaggiAzienda.repositories.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViaggioService {

    @Autowired private ViaggioRepository viaggioRepository;
    @Autowired private ViaggioMapper viaggioMapper;

    public ViaggioDTO generaViaggio(ViaggioDTO viaggioDTO){
        Viaggio viaggio = ViaggioMapper.toEntity(viaggioDTO);
        viaggio = viaggioRepository.save(viaggio);
        return  ViaggioMapper.toDTO(viaggio);
    }

}
