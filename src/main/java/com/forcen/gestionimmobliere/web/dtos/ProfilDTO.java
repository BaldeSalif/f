package com.forcen.gestionimmobliere.web.dtos;

import com.forcen.gestionimmobliere.services.impl.ProfilServiceImpl;

public record ProfilDTO(Long id, String nom) {

    @SuppressWarnings("null")
    public void deleteProfil(ProfilServiceImpl profilServiceImpl) {
         profilServiceImpl.profilRepository.deleteById(id());
    }
    
}
