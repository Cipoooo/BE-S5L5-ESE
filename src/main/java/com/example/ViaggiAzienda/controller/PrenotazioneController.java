package com.example.ViaggiAzienda.controller;
import com.example.ViaggiAzienda.entities.Prenotazione;
import com.example.ViaggiAzienda.entitiesDTO.PrenotazioneDTO;
import com.example.ViaggiAzienda.service.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneService prenotazioneService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PrenotazioneDTO creaPrenotazione(@RequestParam("dipendente id") Long dipendenteId, @RequestParam("viaggio id") Long viaggioID, @RequestParam("dataRichiesta") LocalDate data,@RequestParam("nota") String nota){
        return prenotazioneService.generaPrenotazione(dipendenteId, viaggioID, data, nota);
    }

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<List<Prenotazione>> prendiTuttePrenotazioni(){
        List<Prenotazione> prenotazioneList = prenotazioneService.preniTuttePrenotazioni();
        return new ResponseEntity<>(prenotazioneList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prenotazione> prendiPrenotazioneTramiteId(@PathVariable Long id){
        Prenotazione prenotazione = prenotazioneService.cercaPrenotazioneTramiteId(id);
        return new ResponseEntity<>(prenotazione, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> rimuoviPrenotazioneTramiteId(@PathVariable Long id){
        prenotazioneService.eliminaPrenotazione(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
