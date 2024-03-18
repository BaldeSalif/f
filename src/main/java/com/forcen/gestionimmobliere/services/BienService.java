package com.forcen.gestionimmobliere.services;

import java.util.List;

import com.forcen.gestionimmobliere.web.dtos.BienDTO;

public interface BienService {

     public BienDTO saveBien(BienDTO bienDTO);

     BienDTO updateBien(BienDTO bienDTO);
     String deleteBien(Long id);
     BienDTO findById(Long id);

     List<BienDTO> findAll();
}
