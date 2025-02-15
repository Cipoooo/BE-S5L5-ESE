package com.example.ViaggiAzienda.entitiesDTO;

import com.example.ViaggiAzienda.enumeration.StatoViaggio;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ViaggioDTO {

    private Long id;
    private String destinazione;
    private LocalDate data;
    private StatoViaggio statoViaggio;

}
