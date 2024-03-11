package com.forcen.gestionimmobliere.services;

import java.util.List;

import com.forcen.gestionimmobliere.web.dtos.UtilisateurDTO;

public interface UtilisateurService {
    public UtilisateurDTO saveUtilisateur(UtilisateurDTO utilisateurDTO);
    
    UtilisateurDTO updateUtilisateur(UtilisateurDTO utilisateurDTO);
    String deleteUtilisateur(Long id);
    UtilisateurDTO findById(Long id);
    
    List<UtilisateurDTO> findAll();
}
