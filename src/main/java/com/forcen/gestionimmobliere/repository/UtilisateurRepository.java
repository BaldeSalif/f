package com.forcen.gestionimmobliere.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forcen.gestionimmobliere.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
    
}
