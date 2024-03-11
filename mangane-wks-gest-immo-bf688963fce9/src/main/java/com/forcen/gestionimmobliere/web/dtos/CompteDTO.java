package com.forcen.gestionimmobliere.web.dtos;

import com.forcen.gestionimmobliere.services.impl.CompteServiceImpl;

public record CompteDTO(Long id, String email, String pwd) {

    @SuppressWarnings("null")
    public void deleteCompte(CompteServiceImpl compteServiceImpl) {
        compteServiceImpl.compteRepository.deleteById(id());
    }
    
}
