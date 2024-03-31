package com.forcen.gestionimmobliere.web.dtos;

import java.sql.Date;

import com.forcen.gestionimmobliere.enums.Etat;
import com.forcen.gestionimmobliere.services.impl.CommandeServiceImpl;

public record CommandeDTO(Long id, Date dateComm, Etat etat) {

    @SuppressWarnings("null")
    public void deleteCommande(CommandeServiceImpl commandeServiceImpl) {
         commandeServiceImpl.commandeRepository.deleteById(id());
    }
    
}
