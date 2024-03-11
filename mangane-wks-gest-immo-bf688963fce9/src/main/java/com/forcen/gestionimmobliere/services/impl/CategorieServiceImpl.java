package com.forcen.gestionimmobliere.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.forcen.gestionimmobliere.entities.Categorie;
import com.forcen.gestionimmobliere.repository.CategorieRepository;
import com.forcen.gestionimmobliere.services.CategorieService;
import com.forcen.gestionimmobliere.web.dtos.CategorieDTO;

public class CategorieServiceImpl implements CategorieService {
    public CategorieRepository categorieRepository;
    @Override
    public CategorieDTO saveCategorie(CategorieDTO categorieDTO) {
        Categorie categorie = new Categorie();
        categorie.setLibelle(categorieDTO.libelle());
       
        Categorie savedCategorie = categorieRepository.save(categorie);
        return new CategorieDTO(savedCategorie.getId(),savedCategorie.getLibelle());
    }

    @SuppressWarnings("null")
    @Override
    public CategorieDTO updateCategorie(CategorieDTO categorieDTO){
      Categorie categorie = Categorie.builder()
      .id(categorieDTO.id())
      .libelle(categorieDTO.libelle())
      .build();
      
     Categorie updatedCategorie = categorieRepository.save(categorie);
      return new CategorieDTO(updatedCategorie.getId(), updatedCategorie.getLibelle());
    }

    @SuppressWarnings("null")
    @Override
    public CategorieDTO findById(Long id) {
        Optional<Categorie> optionalCategorie = categorieRepository.findById(id);
        if(optionalCategorie.isPresent()){
            Categorie categorie = optionalCategorie.get();
            return new CategorieDTO(categorie.getId(), categorie.getLibelle());
        }
        return null;
    }

    @Override
    public List<CategorieDTO> findAll(){
        return categorieRepository.findAll()
            .stream()
            .map(tb-> new CategorieDTO(tb.getId(), tb.getLibelle()))
            .collect(Collectors.toList());
    }

    @Override
    public String deleteCategorie(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteCategorie'");
    }
}
