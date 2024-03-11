package com.forcen.gestionimmobliere.services;

import java.util.List;

import com.forcen.gestionimmobliere.web.dtos.CategorieDTO;

public interface CategorieService {
    public CategorieDTO saveCategorie(CategorieDTO categorieDTO);
   
    CategorieDTO updateCategorie(CategorieDTO categorieDTO);
    String deleteCategorie(Long id);
    CategorieDTO findById(Long id);
   
    List<CategorieDTO> findAll();
}
