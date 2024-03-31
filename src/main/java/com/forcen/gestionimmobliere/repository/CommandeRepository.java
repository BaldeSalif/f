package com.forcen.gestionimmobliere.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forcen.gestionimmobliere.entities.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
    
}
