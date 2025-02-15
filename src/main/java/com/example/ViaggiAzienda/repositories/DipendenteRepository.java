package com.example.ViaggiAzienda.repositories;

import com.example.ViaggiAzienda.entities.Dipendente;
import com.example.ViaggiAzienda.entities.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DipendenteRepository extends JpaRepository<Dipendente,Long> {

    Optional<Dipendente> findByUsername(String username);

}
