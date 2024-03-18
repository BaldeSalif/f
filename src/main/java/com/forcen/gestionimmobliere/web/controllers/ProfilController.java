package com.forcen.gestionimmobliere.web.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.forcen.gestionimmobliere.services.ProfilService;
import com.forcen.gestionimmobliere.web.dtos.ProfilDTO;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
@RequestMapping("/profil")
public class ProfilController {
    private ProfilService profilService;

    @GetMapping("/")
    public List<ProfilDTO> getAllProfil(){
        return profilService.findAll();
    }
    @GetMapping("/{id}")
    public  ProfilDTO getProfil(@PathVariable Long id){
        return profilService.findById(id);
    }
    @PostMapping("/")
    public ProfilDTO saveProfil( @RequestBody ProfilDTO profilDTO){
        return profilService.saveProfil(profilDTO);
    }
    @PutMapping("/{id}")
    public ProfilDTO updateProfil(@PathVariable Long id, @RequestBody ProfilDTO profilDTO){
        return profilService.updateProfil(new ProfilDTO(id,profilDTO.nom()));
    }
    @DeleteMapping("/{id}")
    public String deleteProfil(@PathVariable Long id){
         return profilService.deleteProfil(id);
    }
}
