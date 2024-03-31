package com.forcen.gestionimmobliere.services;

import java.util.List;

import com.forcen.gestionimmobliere.web.dtos.UtilisateurDTO;

public interface UtilisateurService {
    public UtilisateurDTO saveUtilisateur(UtilisateurDTO utilisateurDTO);
    
    public UtilisateurDTO updateUtilisateur(UtilisateurDTO utilisateurDTO);

    public String deleteUtilisateur(Long id);

    public UtilisateurDTO findById(Long id);
    
    List<UtilisateurDTO> findAll();
}
