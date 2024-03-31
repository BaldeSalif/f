package com.forcen.gestionimmobliere.repository;

import com.forcen.gestionimmobliere.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
