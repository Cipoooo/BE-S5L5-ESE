package com.example.ViaggiAzienda.repositories;

import com.example.ViaggiAzienda.entities.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViaggioRepository extends JpaRepository<Viaggio,Long> {
}
