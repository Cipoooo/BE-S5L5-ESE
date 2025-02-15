package com.example.ViaggiAzienda.mapper;

import com.example.ViaggiAzienda.entities.Dipendente;
import com.example.ViaggiAzienda.entitiesDTO.DipendenteDTO;
import org.springframework.stereotype.Component;

@Component
public class DipendenteMapper {

    public static DipendenteDTO toDTO(Dipendente dipendente){
        DipendenteDTO dipendenteDTO = new DipendenteDTO();
        dipendenteDTO.setId(dipendente.getId());
        dipendenteDTO.setUsername(dipendente.getUsername());
        dipendenteDTO.setNome(dipendente.getNome());
        dipendenteDTO.setCognome(dipendente.getCognome());
        dipendenteDTO.setEmail(dipendente.getEmail());
        return dipendenteDTO;
    }

    public static Dipendente toEntity(DipendenteDTO dipendenteDTO){
        Dipendente dipendente = new Dipendente();
        dipendente.setId(dipendenteDTO.getId());
        dipendente.setUsername(dipendenteDTO.getUsername());
        dipendente.setNome(dipendenteDTO.getNome());
        dipendente.setCognome(dipendenteDTO.getCognome());
        dipendente.setEmail(dipendenteDTO.getEmail());
        return dipendente;
    }

}
