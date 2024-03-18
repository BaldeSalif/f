package com.forcen.gestionimmobliere.web.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.forcen.gestionimmobliere.services.CommandeService;
import com.forcen.gestionimmobliere.web.dtos.CommandeDTO;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/commande")
public class CommandeController {
    private CommandeService commandeService;

    @PostMapping("/save")
    public CommandeDTO saveCommande(@RequestBody CommandeDTO commandeDTO){
        return  commandeService.saveCommande(commandeDTO);
    }

    @GetMapping("/all")
    public List<CommandeDTO> getAllCommande(){
        return commandeService.findAll() ;
    }

    @GetMapping("/get")
    public CommandeDTO getCommandeById(@PathVariable Long id){
        return commandeService.findById(id) ;
    }

    @PutMapping("/{id}")
    public CommandeDTO updateCommande(@PathVariable Long id, @RequestBody CommandeDTO commandeDTO){
        return commandeService.updateCommande(new CommandeDTO(id,commandeDTO.dateComm(),
                                                                commandeDTO.etat()));
    }
    @DeleteMapping("/{id}")
    public String deleteCommande(@PathVariable Long id){
         return commandeService.deleteCommande(id);
    }

}
