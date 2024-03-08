package com.forcen.gestionimmobliere.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.forcen.gestionimmobliere.entities.Bien;

@Repository
public interface BienRepository extends JpaRepository<Bien, Long>{

    
}
