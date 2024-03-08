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

    @GetMapping("/hello")
    public String text(){
        return "hello";
    }

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
        TypeBienDTO savetypeBienDTO = typeBienService.saveTypeBien(typeBienDTO);
        return savetypeBienDTO;
    }
    @PutMapping("/{id}")
    public TypeBienDTO updateTypeBien(@PathVariable Long id, @RequestBody TypeBienDTO typeBienDTO){
        return typeBienService.updateTypeBien(new TypeBienDTO(id,typeBienDTO.libelle()));
    }

    @DeleteMapping("/")
    public void deleteTypeBien(@RequestBody TypeBienDTO typeBienDTO){
         typeBienService.deleteTypeBien(typeBienDTO);
    }
}
