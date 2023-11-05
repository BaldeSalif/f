package com.forcen.gestionimmobliere.services;

import com.forcen.gestionimmobliere.web.dtos.TypeBienDTO;

import java.util.List;

public interface TypeBienService {

    public TypeBienDTO saveTypeBien(TypeBienDTO typeBienDTO);

    TypeBienDTO updateTypeBien(TypeBienDTO typeBienDTO);
    void deleteTypeBien(TypeBienDTO typeBienDTO);
    TypeBienDTO findById( Long id);

    List<TypeBienDTO> findAll();

}
