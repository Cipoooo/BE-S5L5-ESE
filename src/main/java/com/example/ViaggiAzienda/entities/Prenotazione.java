package com.example.ViaggiAzienda.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataRichiesta;
    private String nota;

    @ManyToOne
    private Viaggio viaggio;
    @ManyToOne
    private Dipendente dipendente;
}
