package com.forcen.gestionimmobliere.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forcen.gestionimmobliere.entities.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long>{
    //Liste des catégories de biens immobiliers
}
