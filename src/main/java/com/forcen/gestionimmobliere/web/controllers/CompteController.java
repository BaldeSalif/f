package com.forcen.gestionimmobliere.web.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;


import com.forcen.gestionimmobliere.services.CompteService;
import com.forcen.gestionimmobliere.web.dtos.CompteDTO;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/compte")
public class CompteController {
    private CompteService compteService;

    @GetMapping("/")
    public List<CompteDTO> getAllCompte(){
        return compteService.findAll();
    }
    @GetMapping("/{id}")
    public  CompteDTO getCompte(@PathVariable Long id){
        return compteService.findById(id);
    }
    @PostMapping("/")
    public CompteDTO saveCompte( @RequestBody CompteDTO compteDTO){
        return compteService.saveCompte(compteDTO);
    }
    @PutMapping("/{id}")
    public CompteDTO updateCompte(@PathVariable Long id, @RequestBody CompteDTO compteDTO){
        return compteService.updateCompte(new CompteDTO(id,compteDTO.email() ,compteDTO.pwd() ));
    }
    @DeleteMapping("/{id}")
    public String deleteCompte(@PathVariable Long id){
         return compteService.deleteCompte(id);
    }
}
