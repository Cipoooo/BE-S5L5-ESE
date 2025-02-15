package com.example.ViaggiAzienda.entitiesDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DipendenteDTO {

    private Long id;
    private String username;
    private String nome;
    private String cognome;
    private String email;
}
