package com.forcen.gestionimmobliere.web.dtos;

import com.forcen.gestionimmobliere.services.impl.CategorieServiceImpl;

public record CategorieDTO(Long id, String libelle) {

    // Supprime ce bloc de code ligne 8 à 11, il y a rien à écrire ici, laisses les accolates vides
    @SuppressWarnings("null")
    public void deleteCategorie(CategorieServiceImpl categorieServiceImpl) {
        categorieServiceImpl.categorieRepository.deleteById(id());
    }
    
}
