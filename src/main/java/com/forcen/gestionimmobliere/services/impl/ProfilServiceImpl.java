package com.forcen.gestionimmobliere.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.forcen.gestionimmobliere.entities.Profil;
import com.forcen.gestionimmobliere.repository.ProfilRepository;
import com.forcen.gestionimmobliere.services.ProfilService;
import com.forcen.gestionimmobliere.web.dtos.ProfilDTO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProfilServiceImpl implements ProfilService{

 public ProfilRepository profilRepository;

    @Override
    public ProfilDTO saveProfil(ProfilDTO profilDTO) {
        Profil profil = new Profil();
        profil.setNom(profilDTO.nom());
        Profil savedProfil = profilRepository.save(profil);
        return new ProfilDTO(savedProfil.getId(),savedProfil.getNom());
    }

    @SuppressWarnings("null")
    @Override
    public ProfilDTO updateProfil(ProfilDTO profilDTO) {
        Profil profil = Profil.builder().id(profilDTO.id())
            .nom(profilDTO.nom())
            .build();

        Profil updatedProfil = profilRepository.save(profil);
        return  new ProfilDTO(updatedProfil.getId(),updatedProfil.getNom());
    }

    @SuppressWarnings("null")
    @Override
    public ProfilDTO findById(Long id) {
        Optional<Profil> optionalProfil = profilRepository.findById(id);
        if(optionalProfil.isPresent()){
            Profil profil = optionalProfil.get();
            return new ProfilDTO(profil.getId(), profil.getNom());
        }
        return null;
    }

    @Override
    public List<ProfilDTO> findAll(){
        return profilRepository.findAll()
            .stream()
            .map(tb-> new ProfilDTO(tb.getId(), tb.getNom()))
            .collect(Collectors.toList());
    }

    @Override
    public String deleteProfil(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteProfil'");
    }
    
}
