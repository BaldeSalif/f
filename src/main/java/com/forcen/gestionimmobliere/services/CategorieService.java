package com.forcen.gestionimmobliere.services;

import java.util.List;

import com.forcen.gestionimmobliere.web.dtos.CategorieDTO;
import org.springframework.stereotype.Service;

public interface CategorieService {
    List<CategorieDTO> findAll();

    CategorieDTO saveCategorie(CategorieDTO categorieDTO);

    CategorieDTO updateCategorie(CategorieDTO categorieDTO);

    CategorieDTO findById(Long id);

    String deleteCategorie(Long id);
}
