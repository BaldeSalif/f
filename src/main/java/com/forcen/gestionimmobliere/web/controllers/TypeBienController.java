package com.forcen.gestionimmobliere.web.controllers;

import com.forcen.gestionimmobliere.services.TypeBienService;
import com.forcen.gestionimmobliere.web.dtos.TypeBienDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/typebiens")
@AllArgsConstructor
@CrossOrigin("*")
public class TypeBienController {
    private TypeBienService typeBienService;
    
    @GetMapping("/")
    public List<TypeBienDTO> getAllTypeBien(){
        return typeBienService.findAll();
    }
    @GetMapping("/{id}")
    public  TypeBienDTO getTypeBien(@PathVariable Long id){
        return typeBienService.findById(id);
    }
    @PostMapping("/")
    public TypeBienDTO saveTypeBien( @RequestBody TypeBienDTO typeBienDTO){
        return typeBienService.saveTypeBien(typeBienDTO);
    }
    @PutMapping("/{id}")
    public TypeBienDTO updateTypeBien(@PathVariable Long id, @RequestBody TypeBienDTO typeBienDTO){
        return typeBienService.updateTypeBien(new TypeBienDTO(id,typeBienDTO.libelle()));
    }
    @DeleteMapping("/{id}")
    public String deleteTypeBien(@PathVariable Long id){
         return typeBienService.deleteTypeBien(id);
    }
}

