package com.forcen.gestionimmobliere.services;

import java.util.List;

import com.forcen.gestionimmobliere.web.dtos.UtilisateurDTO;

public interface UtilisateurService {
    public UtilisateurDTO saveUtilisateur(UtilisateurDTO utilisateurDTO);
    
    UtilisateurDTO updateUtilisateur(UtilisateurDTO utilisateurDTO);
    void deleteUtilisateur(UtilisateurDTO utilisateurDTO);
    UtilisateurDTO findById(Long id);
    
    List<UtilisateurDTO> findAll();
}
