package com.forcen.gestionimmobliere.web.controllers;

import com.forcen.gestionimmobliere.services.UtilisateurService;
import com.forcen.gestionimmobliere.web.dtos.UtilisateurDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/users")
public class UtilisateurController {

    private UtilisateurService utilisateurService;

    @PostMapping("/create")
    public UtilisateurDTO saveUtilisateur(@RequestBody UtilisateurDTO utilisateurDTO){
        return utilisateurService.saveUtilisateur(utilisateurDTO);
    }

    @GetMapping("/read/all")
    public List<UtilisateurDTO> getAllUtilisateurs(){
        return utilisateurService.findAll();
    }

    @GetMapping("/read/{id}")
    public UtilisateurDTO getUtilisateurById(@PathVariable Long id){
        return utilisateurService.findById(id);
    }

    @PutMapping("/update/{id}")
    public UtilisateurDTO updateUtilisateur(@PathVariable Long id, @RequestBody UtilisateurDTO utilisateurDTO){
        return utilisateurService.updateUtilisateur(
                new UtilisateurDTO(
                        id,
                        utilisateurDTO.prenom(),
                        utilisateurDTO.nom(),
                        utilisateurDTO.adresse(),
                        utilisateurDTO.telephone()
                )
        );
    }

    @DeleteMapping("delete/{id}")
    public String deleteUtilisateur(@PathVariable Long id){
        return utilisateurService.deleteUtilisateur(id);
    }
}
