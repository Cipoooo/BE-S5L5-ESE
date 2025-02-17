package com.example.ViaggiAzienda.controller;

import com.example.ViaggiAzienda.entities.Dipendente;
import com.example.ViaggiAzienda.entities.Viaggio;
import com.example.ViaggiAzienda.entitiesDTO.DipendenteDTO;
import com.example.ViaggiAzienda.service.DipendenteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteController {

    @Autowired DipendenteService dipendenteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DipendenteDTO creaDipendente(@RequestBody @Valid DipendenteDTO dipendenteDTO){
        return dipendenteService.generaDipendente(dipendenteDTO);
    }
    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<List<Dipendente>> prendiTuttiDipendenti(){
        List<Dipendente> dipendenteList = dipendenteService.prendiTuttiDipendenti();
        return new ResponseEntity<>(dipendenteList,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Dipendente>> prendiDipendenteTramiteId(@PathVariable Long id){
        Optional<Dipendente> dipendeteList = dipendenteService.prendiDipendenteTramiteId(id);
        return new ResponseEntity<>(dipendeteList,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> rimuoviDipendente(@PathVariable Long id){
        dipendenteService.rimuoviDipendenteTramiteId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
