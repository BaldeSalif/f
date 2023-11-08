package com.forcen.gestionimmobliere.web.dtos;

import java.sql.Date;

import com.forcen.gestionimmobliere.enums.Etat;

public record CommandeDTO(Long id, Date dateComm, Etat etat) {
    
}
