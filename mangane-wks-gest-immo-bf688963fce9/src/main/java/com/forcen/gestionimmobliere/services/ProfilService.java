package com.forcen.gestionimmobliere.services;

import java.util.List;

import com.forcen.gestionimmobliere.web.dtos.ProfilDTO;

public interface ProfilService {
    public ProfilDTO saveProfil(ProfilDTO profilDTO);
    
    ProfilDTO updateProfil(ProfilDTO profilDTO);
    void deleteProfil(ProfilDTO profilDTO);
    ProfilDTO findById(Long id);
    
    List<ProfilDTO> findAll();
}
