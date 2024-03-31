package com.forcen.gestionimmobliere.services.impl;

import java.util.List;
import java.util.Optional;

import com.forcen.gestionimmobliere.entities.Categorie;
import com.forcen.gestionimmobliere.repository.CategorieRepository;
import com.forcen.gestionimmobliere.services.CategorieService;
import com.forcen.gestionimmobliere.web.dtos.CategorieDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CategorieServiceImpl implements CategorieService {

    private CategorieRepository categorieRepository;
    @Override
    public CategorieDTO saveCategorie(CategorieDTO categorieDTO) {
        Categorie categorie = Categorie.builder()
                .libelle(categorieDTO.libelle())
                .build();
        Categorie savedCategorie = categorieRepository.save(categorie);
        return new CategorieDTO(savedCategorie.getId(),savedCategorie.getLibelle());
    }

    @Override
    public CategorieDTO updateCategorie(CategorieDTO categorieDTO){
      Categorie categorie = Categorie.builder()
      .id(categorieDTO.id())
      .libelle(categorieDTO.libelle())
      .build();
      Categorie updatedCategorie = categorieRepository.save(categorie);
      return new CategorieDTO(updatedCategorie.getId(), updatedCategorie.getLibelle());
    }

    @Override
    public String deleteCategorie(Long id) {
        categorieRepository.deleteById(id);
        return "Category deleted by successfully";
    }

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
            .toList();
    }
}
