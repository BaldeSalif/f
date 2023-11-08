package com.forcen.gestionimmobliere.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.forcen.gestionimmobliere.entities.Bien;
import com.forcen.gestionimmobliere.repository.BienRepository;
import com.forcen.gestionimmobliere.services.BienService;
import com.forcen.gestionimmobliere.web.dtos.BienDTO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BienServiceImpl implements BienService{
    
    BienRepository bienRepository;
    
    @Override
    public BienDTO saveBien(BienDTO bienDTO) {
        Bien bien = new Bien();
        bien.setNom(bienDTO.nom());
        bien.setAddress(bienDTO.adresse());
        bien.setDescription(bienDTO.description());
        bien.setPrix(bienDTO.prix());

        Bien savedBien = bienRepository.save(bien);
        return new BienDTO(savedBien.getId(),savedBien.getNom(), savedBien.getAddress(), savedBien.getDescription(), savedBien.getPrix());
    }

    @Override
    public BienDTO updateBien(BienDTO bienDTO){
      Bien bien = Bien.builder().id(bienDTO.id())
      .nom(bienDTO.nom())
      .address(bienDTO.adresse())
      .description(bienDTO.description())
      .prix(bienDTO.prix())
      .build();
      
      Bien updatedBien = bienRepository.save(bien);
      return new BienDTO(updatedBien.getId(), updatedBien.getNom(), updatedBien.getAddress(), updatedBien.getDescription(), updatedBien.getPrix());
    }

    @Override
    public void deleteBien(BienDTO bienDTO) {
        bienRepository.deleteById(bienDTO.id());
    }

     @Override
    public BienDTO findById(Long id) {
        Optional<Bien> optionalBien = bienRepository.findById(id);
        if(optionalBien.isPresent()){
            Bien bien = optionalBien.get();
            return new BienDTO(bien.getId(), bien.getNom(), bien.getAddress(), bien.getDescription(), bien.getPrix());
        }
        return null;
    }

    @Override
    public List<BienDTO> findAll(){
        return bienRepository.findAll()
            .stream()
            .map(tb-> new BienDTO(tb.getId(), tb.getNom(), tb.getAddress(), tb.getDescription(), tb.getPrix()))
            .collect(Collectors.toList());
    }
        
        
}
       
