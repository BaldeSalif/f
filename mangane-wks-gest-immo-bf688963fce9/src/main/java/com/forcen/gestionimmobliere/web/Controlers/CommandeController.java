package com.forcen.gestionimmobliere.web.Controlers;

import org.springframework.web.bind.annotation.*;

import com.forcen.gestionimmobliere.services.CommandeService;
import com.forcen.gestionimmobliere.web.dtos.CommandeDTO;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;
import java.util.*;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/commande")
public class CommandeController {
     private CommandeService commandeService;

    @PostMapping("/create")
    public CommandeDTO saveCommande(@RequestBody CommandeDTO commandeDTO){
        return commandeService.saveCommande(commandeDTO);
    }

    @GetMapping("/read/all")
    public List<CommandeDTO> getAllCommande(){
        return commandeService.findAll();
    }

    @GetMapping("/read/{id}")
    public CommandeDTO getCommandeById(@PathVariable Long id){
        return commandeService.findById(id);
    }

     @PutMapping("/update/{id}")
    public CommandeDTO updateCommande(@PathVariable Long id, @RequestBody CommandeDTO commandeDTO){
        return commandeService.updateCommande(
                new CommandeDTO(
                        id,
                        commandeDTO.dateComm(),
                        commandeDTO.etat()
                )
        );
    }

   
    @DeleteMapping("delete/{id}")
    public String deleteCommandeString(@PathVariable Long id){
        return commandeService.deleteCommande(id);
    }
}
