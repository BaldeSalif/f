package com.forcen.gestionimmobliere.web.dtos;

import com.forcen.gestionimmobliere.services.impl.CategorieServiceImpl;

public record CategorieDTO(Long id, String libelle) {

    @SuppressWarnings("null")
    public void deleteCategorie(CategorieServiceImpl categorieServiceImpl) {
        categorieServiceImpl.categorieRepository.deleteById(id());
    }
    
}
