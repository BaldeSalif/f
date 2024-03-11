package com.forcen.gestionimmobliere.web.Controlers;

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

    @PostMapping("/create")
    public CompteDTO saveCompte(@RequestBody CompteDTO compteDTO){
        return compteService.saveCompte(compteDTO);
    }

    @GetMapping("/read/all")
    public List<CompteDTO> getAllCompte(){
        return compteService.findAll();
    }

    @GetMapping("/read/{id}")
    public CompteDTO getCompteById(@PathVariable Long id){
        return compteService.findById(id);
    }

    @PutMapping("/update/{id}")
    public CompteDTO updateCompte(@PathVariable Long id, @RequestBody CompteDTO compteDTO){
        return compteService.updateCompte(
                new CompteDTO(
                        id,
                        compteDTO.pwd(),
                        compteDTO.email()
                        
                )
        );
    }

    @DeleteMapping("delete/{id}")
    public String deleteCompte(@PathVariable Long id){
        return compteService.deleteCompte(id);
    }
}
