package com.forcen.gestionimmobliere.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forcen.gestionimmobliere.entities.Categorie;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long>{

}
