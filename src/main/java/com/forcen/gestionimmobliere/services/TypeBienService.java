package com.forcen.gestionimmobliere.services;

import com.forcen.gestionimmobliere.web.dtos.TypeBienDTO;

import java.util.List;

public interface TypeBienService {

    public TypeBienDTO saveTypeBien(TypeBienDTO typeBienDTO);

    public TypeBienDTO updateTypeBien(TypeBienDTO typeBienDTO);

    public String deleteTypeBien(Long id);

    public TypeBienDTO findById( Long id);

    public List<TypeBienDTO> findAll();

}
