package com.example.ViaggiAzienda.controller;

import com.example.ViaggiAzienda.entitiesDTO.ViaggioDTO;
import com.example.ViaggiAzienda.enumeration.StatoViaggio;
import com.example.ViaggiAzienda.service.ViaggioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/viaggi")
public class ViaggioController {

    @Autowired ViaggioService viaggioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ViaggioDTO generaViaggio(@RequestBody @Valid ViaggioDTO viaggioDTO){
        return viaggioService.generaViaggio(viaggioDTO);
    }

    @PutMapping("/{id}/statoViaggio")
    @ResponseStatus(HttpStatus.OK)
    public ViaggioDTO aggiornaViaggio(@PathVariable Long id, @RequestBody StatoViaggio statoViaggio){
        return viaggioService.aggiornaViaggio(id,statoViaggio);
    }

}
