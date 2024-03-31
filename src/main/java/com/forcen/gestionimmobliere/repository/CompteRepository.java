package com.forcen.gestionimmobliere.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forcen.gestionimmobliere.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long>{
    
}
