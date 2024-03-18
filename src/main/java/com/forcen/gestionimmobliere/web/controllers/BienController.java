package com.forcen.gestionimmobliere.web.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.forcen.gestionimmobliere.services.BienService;
import com.forcen.gestionimmobliere.web.dtos.BienDTO;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/bien")
@CrossOrigin("*")
public class BienController {
     private BienService bienService;
    
    @GetMapping("/")
    public List<BienDTO> getAllBien(){
        return bienService.findAll();
    }
    @GetMapping("/{id}")
    public  BienDTO getBien(@PathVariable Long id){
        return bienService.findById(id);
    }
    @PostMapping("/")
    public BienDTO saveBien( @RequestBody BienDTO bienDTO){
        return bienService.saveBien(bienDTO);
    }
    @PutMapping("/{id}")
    public BienDTO updateBien(@PathVariable Long id, @RequestBody BienDTO bienDTO){
        return bienService.updateBien(new BienDTO(id,bienDTO.nom(),
                                                        bienDTO.adresse(),
                                                        bienDTO.description(),
                                                        bienDTO.prix()));
    }
    @DeleteMapping("/{id}")
    public String deleteBien(@PathVariable Long id){
         return bienService.deleteBien(id);
    }
}
