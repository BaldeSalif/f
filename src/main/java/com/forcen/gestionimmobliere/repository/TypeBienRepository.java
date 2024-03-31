package com.forcen.gestionimmobliere.repository;

import com.forcen.gestionimmobliere.entities.TypeBien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeBienRepository extends JpaRepository<TypeBien, Long> {

}
