package com.example.ViaggiAzienda.controller;

import com.example.ViaggiAzienda.entitiesDTO.PrenotazioneDTO;
import com.example.ViaggiAzienda.service.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/prenotazioni")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneService prenotazioneService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PrenotazioneDTO creaPrenotazione(@RequestParam("dipendente id") Long dipendenteId, @RequestParam("viaggio id") Long viaggioID, @RequestParam("dataRichiesta") LocalDate data,@RequestParam("nota") String nota){
        return prenotazioneService.generaPrenotazione(dipendenteId, viaggioID, data, nota);
    }
}
