package com.forcen.gestionimmobliere.services.impl;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.forcen.gestionimmobliere.entities.Commande;
import com.forcen.gestionimmobliere.repository.CommandeRepository;
import com.forcen.gestionimmobliere.services.CommandeService;
import com.forcen.gestionimmobliere.web.dtos.CommandeDTO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CommandeServiceImpl implements CommandeService{
    
    CommandeRepository commandeRepository;

    @Override
    public CommandeDTO saveCommande(CommandeDTO commandeDTO){
        Commande commande = new Commande();
        commande.setDateComm(commandeDTO.dateComm());
        commande.setEtat(commandeDTO.etat());
        Commande savedCommande = commandeRepository.save(commande);
        return new CommandeDTO(savedCommande.getId(), (Date) savedCommande.getDateComm(), savedCommande.getEtat());
    }
    

    @Override
    public CommandeDTO updateCommande(CommandeDTO commandeDTO) {
        Commande commande = Commande.builder().id(commandeDTO.id())
            .dateComm(commandeDTO.dateComm())
            .etat(commandeDTO.etat())
            .build();

        Commande updatedCommande = commandeRepository.save(commande);
        return  new CommandeDTO(updatedCommande.getId(),(Date) updatedCommande.getDateComm(), updatedCommande.getEtat());
    }

    @Override
    public void deleteCommande(CommandeDTO commandeDTO) {
         commandeRepository.deleteById(commandeDTO.id());
    }

    @Override
    public CommandeDTO findById(Long id) {
        Optional<Commande> optionalCommande =commandeRepository.findById(id);
        if(optionalCommande.isPresent()){
            Commande commande = optionalCommande.get();
            return new CommandeDTO(commande.getId(), (Date) commande.getDateComm(), commande.getEtat());
        }
        return null;
    }

    @Override
    public List<CommandeDTO> findAll(){
        return commandeRepository.findAll()
            .stream()
            .map(tb-> new CommandeDTO(tb.getId(), (Date) tb.getDateComm(), tb.getEtat()))
            .collect(Collectors.toList());
    }
}
