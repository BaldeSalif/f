package com.forcen.gestionimmobliere.web.Controlers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.forcen.gestionimmobliere.services.CategorieService;
import com.forcen.gestionimmobliere.web.dtos.CategorieDTO;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
@RequestMapping("/categorie")
public class CategorieController {
    // Enlève le mot clé 'private' ici et laisse comme ça
    private CategorieService categorieService;

    @PostMapping("/create")
    public CategorieDTO saveCategorie(@RequestBody CategorieDTO categorieDTO){
        return categorieService.saveCategorie(categorieDTO);
    }

    @GetMapping("/read/all")
    public List<CategorieDTO> getAllCategorie(){
        return categorieService.findAll();
    }

    @GetMapping("/read/{id}")
    public CategorieDTO getCategorieById(@PathVariable Long id){
        return categorieService.findById(id);
    }

     @PutMapping("/update/{id}")
    public CategorieDTO updateCategorie(@PathVariable Long id, @RequestBody CategorieDTO categorieDTO){
        return categorieService.updateCategorie(
                new CategorieDTO(
                        id,
                        categorieDTO.libelle()
                )
        );
    }

   
    @DeleteMapping("delete/{id}")
    public String deleteCategorie(@PathVariable Long id){
        return categorieService.deleteCategorie(id);
    }
    
}
