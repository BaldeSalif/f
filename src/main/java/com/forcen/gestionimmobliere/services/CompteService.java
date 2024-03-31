package com.forcen.gestionimmobliere.services;

import java.util.List;

import com.forcen.gestionimmobliere.web.dtos.CompteDTO;

public interface CompteService {
    public CompteDTO saveCompte(CompteDTO compteDTO);
   
    CompteDTO updateCompte(CompteDTO compteDTO);
    String deleteCompte(Long id);
    CompteDTO findById(Long id);
    
    List<CompteDTO> findAll();
}
