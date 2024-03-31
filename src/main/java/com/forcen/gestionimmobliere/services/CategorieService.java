package com.forcen.gestionimmobliere.services;

import java.util.List;

import com.forcen.gestionimmobliere.web.dtos.CategorieDTO;
import org.springframework.stereotype.Service;

@Service
public interface CategorieService {
    public List<CategorieDTO> findAll();

    public CategorieDTO saveCategorie(CategorieDTO categorieDTO);

    public CategorieDTO updateCategorie(CategorieDTO categorieDTO);

    public CategorieDTO findById(Long id);

    public String deleteCategorie(Long id);
}
