package com.example.ViaggiAzienda.repositories;

import com.example.ViaggiAzienda.entities.Dipendente;
import com.example.ViaggiAzienda.entities.Prenotazione;
import com.example.ViaggiAzienda.entities.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione,Long> {

    boolean seEsisteDipeData(Dipendente dipendente, LocalDate data);

}
