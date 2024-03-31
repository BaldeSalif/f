package com.forcen.gestionimmobliere.services.impl;

import java.util.Optional;
import java.util.List;
import org.springframework.stereotype.Service;
import com.forcen.gestionimmobliere.entities.Compte;
import com.forcen.gestionimmobliere.repository.CompteRepository;
import com.forcen.gestionimmobliere.services.CompteService;
import com.forcen.gestionimmobliere.web.dtos.CompteDTO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CompteServiceImpl implements CompteService{
    private CompteRepository compteRepository;

    @Override
    public CompteDTO saveCompte(CompteDTO compteDTO){
        Compte compte = new Compte();
        compte.setEmail(compteDTO.email());
        compte.setPwd(compteDTO.pwd());

        Compte savedCompte = compteRepository.save(compte);
        return new CompteDTO(savedCompte.getId(), savedCompte.getEmail(), savedCompte.getPwd());
    }

    @SuppressWarnings("null")
    @Override
    public CompteDTO updateCompte(CompteDTO compteDTO){
        Compte compte = Compte.builder()
        .id(compteDTO.id())
        .email(compteDTO.email())
        .pwd(compteDTO.pwd())
        .build();
        Compte updatedCompte = compteRepository.save(compte);
        return new CompteDTO(updatedCompte.getId(), updatedCompte.getEmail(), updatedCompte.getPwd());
    }

    @SuppressWarnings("null")
    @Override
    public CompteDTO findById(Long id){
        Optional<Compte> optionalCompte = compteRepository.findById(id);
        if (optionalCompte.isPresent()) {
            Compte compte = optionalCompte.get();
            return new CompteDTO(compte.getId(), compte.getEmail(), compte.getPwd());
        }
        return null;
    }    

    
    @Override
    public List<CompteDTO> findAll(){
        return compteRepository.findAll()
        .stream()
        .map(tb -> new CompteDTO(tb.getId(), tb.getEmail(), tb.getPwd()))
        .toList();
        
    }

    @Override
    public String deleteCompte(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteCompte'");
    }
}
            
    
        

