package com.forcen.gestionimmobliere.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.forcen.gestionimmobliere.entities.Utilisateur;
import com.forcen.gestionimmobliere.repository.UtilisateurRepository;
import com.forcen.gestionimmobliere.services.UtilisateurService;
import com.forcen.gestionimmobliere.web.dtos.UtilisateurDTO;

import lombok.AllArgsConstructor;

@SuppressWarnings("null")
@Service
@AllArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService{

    public UtilisateurRepository utilisateurRepository;

    @Override
    public UtilisateurDTO saveUtilisateur(UtilisateurDTO utilisateurDTO) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setPrenom(utilisateurDTO.prenom());
        utilisateur.setNom(utilisateurDTO.nom());
        utilisateur.setAdresse(utilisateurDTO.adresse());
        utilisateur.setTelephone(utilisateurDTO.telephone());

        Utilisateur savedUtilisateur = utilisateurRepository.save(utilisateur);
        return new UtilisateurDTO(
                savedUtilisateur.getId(),
                savedUtilisateur.getPrenom(),
                savedUtilisateur.getNom(),
                savedUtilisateur.getAdresse(),
                savedUtilisateur.getTelephone()
        );
    }

    @Override
    public UtilisateurDTO updateUtilisateur(UtilisateurDTO utilisateurDTO) {
        Utilisateur utilisateur = Utilisateur.builder()
            .id(utilisateurDTO.id())
            .prenom(utilisateurDTO.prenom())
            .nom(utilisateurDTO.nom())
            .adresse(utilisateurDTO.adresse())
            .telephone(utilisateurDTO.telephone())
            .build();
            
        Utilisateur updatedUtilisateur = utilisateurRepository.save(utilisateur);
        return  new UtilisateurDTO(
                updatedUtilisateur.getId(),
                updatedUtilisateur.getPrenom(),
                updatedUtilisateur.getNom(),
                updatedUtilisateur.getAdresse(),
                updatedUtilisateur.getTelephone()
        );
    }
    
    @Override
    public String deleteUtilisateur(Long id) {
         utilisateurRepository.deleteById(id);
         return "User is deleted by successfully !";
    }

    @Override
    public UtilisateurDTO findById(Long id) {
        Optional<Utilisateur> optionalUtilisateur = utilisateurRepository.findById(id);
        if(optionalUtilisateur.isPresent()){
            Utilisateur utilisateur = optionalUtilisateur.get();
            return new UtilisateurDTO(
                    utilisateur.getId(),
                    utilisateur.getPrenom(),
                    utilisateur.getNom(),
                    utilisateur.getAdresse(),
                    utilisateur.getTelephone()
            );
        }
        return null;
    }

    @Override
    public List<UtilisateurDTO> findAll(){
        return utilisateurRepository.findAll()
            .stream()
            .map(tb-> new UtilisateurDTO(tb.getId(), tb.getPrenom(), tb.getNom(), tb.getAdresse(), tb.getTelephone()))
                .toList();
    }

}
