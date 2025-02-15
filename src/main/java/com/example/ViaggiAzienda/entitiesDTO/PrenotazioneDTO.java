package com.example.ViaggiAzienda.entitiesDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PrenotazioneDTO {

    private Long id;
    private LocalDate dataRichiesta;
    private String nota;
    private Long viaggioId;
    private Long dipendenteId;
}
