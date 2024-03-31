package com.forcen.gestionimmobliere.services;

import java.util.List;

import com.forcen.gestionimmobliere.web.dtos.ProfilDTO;

public interface ProfilService {
    public ProfilDTO saveProfil(ProfilDTO profilDTO);
    
    ProfilDTO updateProfil(ProfilDTO profilDTO);
    String deleteProfil(Long id);
    ProfilDTO findById(Long id);
    
    List<ProfilDTO> findAll();
}
