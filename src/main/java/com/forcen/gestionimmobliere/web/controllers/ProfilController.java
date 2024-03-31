package com.forcen.gestionimmobliere.web.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.forcen.gestionimmobliere.services.ProfilService;
import com.forcen.gestionimmobliere.web.dtos.ProfilDTO;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/profil")
public class ProfilController {
    private ProfilService profilService;

    @PostMapping("/create")
    public ProfilDTO saveProfil(@RequestBody ProfilDTO profilDTO){
        return profilService.saveProfil(profilDTO);
    }

    @GetMapping("/read/all")
    public List<ProfilDTO> getAllProfil(){
        return profilService.findAll();
    }

    @GetMapping("/read/{id}")
    public ProfilDTO getProfilById(@PathVariable Long id){
        return profilService.findById(id);
    }

     @PutMapping("/update/{id}")
    public ProfilDTO updateProfil(@PathVariable Long id, @RequestBody ProfilDTO profilDTO){
        return profilService.updateProfil(
                new ProfilDTO(
                        id,
                        profilDTO.nom()
                )
        );
    }

    @DeleteMapping("delete/{id}")
    public String deleteProfil(@PathVariable Long id){
        return profilService.deleteProfil(id);
    }
}
