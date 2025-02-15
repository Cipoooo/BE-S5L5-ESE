package com.example.ViaggiAzienda.controller;

import com.example.ViaggiAzienda.entitiesDTO.DipendenteDTO;
import com.example.ViaggiAzienda.service.DipendenteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dipendenti")
public class DipendenteController {

    @Autowired DipendenteService dipendenteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DipendenteDTO creaDipendente(@RequestBody @Valid DipendenteDTO dipendenteDTO){
        return dipendenteService.generaDipendente(dipendenteDTO);
    }
}
