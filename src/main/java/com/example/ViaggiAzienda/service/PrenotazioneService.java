package com.example.ViaggiAzienda.service;

import com.example.ViaggiAzienda.entities.Dipendente;
import com.example.ViaggiAzienda.entities.Prenotazione;
import com.example.ViaggiAzienda.entities.Viaggio;
import com.example.ViaggiAzienda.entitiesDTO.PrenotazioneDTO;
import com.example.ViaggiAzienda.mapper.PrenotazioneMapper;
import com.example.ViaggiAzienda.repositories.DipendenteRepository;
import com.example.ViaggiAzienda.repositories.PrenotazioneRepository;
import com.example.ViaggiAzienda.repositories.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class PrenotazioneService {

    @Autowired PrenotazioneRepository prenotazioneRepository;
    @Autowired PrenotazioneMapper prenotazioneMapper;
    @Autowired DipendenteRepository dipendenteRepository;
    @Autowired ViaggioRepository viaggioRepository;

    public PrenotazioneDTO generaPrenotazione(Long dipendenteId, Long viaggioId, LocalDate data, String nota){

        Optional<Dipendente> dipendenteOptional = dipendenteRepository.findById(dipendenteId);
        if (!dipendenteOptional.isPresent()){
            throw new IllegalArgumentException("Dipendente non trovato con questo id");
        }
        Dipendente dipendente = dipendenteOptional.get();

        Optional<Viaggio> viaggioOptional = viaggioRepository.findById(viaggioId);
        if (!viaggioOptional.isPresent()){
            throw new IllegalArgumentException("Viaggio non trovato con questo id");
        }
        Viaggio viaggio = viaggioOptional.get();

        if (prenotazioneRepository.seEsisteDipeData(dipendente,data)){
            throw new IllegalArgumentException("Dipendente è gia impiegato in un altro viaggio");
        }

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setDipendente(dipendente);
        prenotazione.setViaggio(viaggio);
        prenotazione.setDataRichiesta(data);
        prenotazione.setNota(nota);
        prenotazione = prenotazioneRepository.save(prenotazione);

        return prenotazioneMapper.toDTO(prenotazione);
    }
}
