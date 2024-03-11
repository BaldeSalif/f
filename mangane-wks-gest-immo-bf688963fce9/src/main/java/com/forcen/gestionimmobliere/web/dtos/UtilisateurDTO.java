package com.forcen.gestionimmobliere.web.dtos;

import com.forcen.gestionimmobliere.services.impl.UtilisateurServiceImpl;

public record UtilisateurDTO(Long id, String prenom, String nom, String adresse, int telephone) {

    @SuppressWarnings("null")
    public void deleteUtilisateur(UtilisateurServiceImpl utilisateurServiceImpl) {
         utilisateurServiceImpl.utilisateurRepository.deleteById(id());
    }
    
}
