package com.example.ViaggiAzienda.controller;

import com.example.ViaggiAzienda.entities.Viaggio;
import com.example.ViaggiAzienda.entitiesDTO.ViaggioDTO;
import com.example.ViaggiAzienda.enumeration.StatoViaggio;
import com.example.ViaggiAzienda.service.ViaggioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/viaggio")
public class ViaggioController {

    @Autowired ViaggioService viaggioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ViaggioDTO generaViaggio(@RequestBody @Valid ViaggioDTO viaggioDTO){
        return viaggioService.generaViaggio(viaggioDTO);
    }

    @PutMapping("/modifica/{id}/statoViaggio")
    @ResponseStatus(HttpStatus.OK)
    public ViaggioDTO aggiornaViaggio(@PathVariable Long id, @RequestBody StatoViaggio statoViaggio){
        return viaggioService.aggiornaViaggio(id,statoViaggio);
    }

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<List<Viaggio>> prendiTuttiViaggi(){
        List<Viaggio> viaggi = viaggioService.prendiTuttiViaggi();
        return new ResponseEntity<>(viaggi,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Viaggio>> prendiViaggioTramiteId(@PathVariable Long id){
        Optional<Viaggio> viaggio = viaggioService.prendiViaggioTramiteId(id);
        return new ResponseEntity<>(viaggio,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> rimuoviViaggio(@PathVariable Long id){
        viaggioService.rimuoviViaggioTramiteId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
