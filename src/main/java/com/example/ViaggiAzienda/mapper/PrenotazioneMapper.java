package com.example.ViaggiAzienda.mapper;

import com.example.ViaggiAzienda.entities.Prenotazione;
import com.example.ViaggiAzienda.entitiesDTO.PrenotazioneDTO;
import org.springframework.stereotype.Component;


@Component
public class PrenotazioneMapper {

    public PrenotazioneDTO toDTO(Prenotazione prenotazione){
        PrenotazioneDTO prenotazioneDTO = new PrenotazioneDTO();
        prenotazioneDTO.setId(prenotazione.getId());
        prenotazioneDTO.setViaggioId(prenotazione.getViaggio().getId());
        prenotazioneDTO.setDipendenteId(prenotazione.getDipendente().getId());
        prenotazioneDTO.setDataRichiesta(prenotazione.getDataRichiesta());
        prenotazioneDTO.setNota(prenotazione.getNota());
        return prenotazioneDTO;
    }


    public Prenotazione toEntity(PrenotazioneDTO prenotazioneDTO){
        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setId(prenotazioneDTO.getId());
        //prenotazione.setViaggio(viaggio);
        //prenotazione.setDipendente(dipendente);
        prenotazione.setDataRichiesta(prenotazioneDTO.getDataRichiesta());
        prenotazione.setNota(prenotazioneDTO.getNota());
        return prenotazione;
    }
}
