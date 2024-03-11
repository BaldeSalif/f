package com.forcen.gestionimmobliere.services;

import java.util.List;
import com.forcen.gestionimmobliere.web.dtos.CommandeDTO;

public interface CommandeService {
    public CommandeDTO saveCommande(CommandeDTO commandeDTO);
   
    CommandeDTO updateCommande(CommandeDTO commandeDTO);
    String deleteCommande(Long id);
    CommandeDTO findById(Long id);
   
    List<CommandeDTO> findAll();
}
