package com.forcen.gestionimmobliere.services.impl;

import com.forcen.gestionimmobliere.entities.TypeBien;
import com.forcen.gestionimmobliere.repository.TypeBienRepository;
import com.forcen.gestionimmobliere.services.TypeBienService;
import com.forcen.gestionimmobliere.web.dtos.TypeBienDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TypeBienServiceImpl implements TypeBienService {

    private TypeBienRepository typeBienRepository;
    @Override
    public TypeBienDTO saveTypeBien(TypeBienDTO typeBienDTO) {
        TypeBien typeBien = new TypeBien();
        typeBien.setLibelle(typeBienDTO.libelle());
        TypeBien savedTypeBien = typeBienRepository.save(typeBien);
        return new TypeBienDTO(savedTypeBien.getId(),savedTypeBien.getLibelle());
    }

    @SuppressWarnings("null")
    @Override
    public TypeBienDTO updateTypeBien(TypeBienDTO typeBienDTO) {
        TypeBien typeBien = TypeBien.builder().id(typeBienDTO.id())
            .libelle(typeBienDTO.libelle())
            .build();

        TypeBien updatedTypeBien = typeBienRepository.save(typeBien);
        return  new TypeBienDTO(updatedTypeBien.getId(),updatedTypeBien.getLibelle());
    }

    @SuppressWarnings("null")
    @Override
    public String deleteTypeBien(Long id) {
         typeBienRepository.deleteById(id);
         return "Type bien is deleted by successfully !";
    }

    @SuppressWarnings("null")
    @Override
    public TypeBienDTO findById(Long id) {
        Optional<TypeBien> optionalTypeBien = typeBienRepository.findById(id);
        if(optionalTypeBien.isPresent()){
            TypeBien typeBien = optionalTypeBien.get();
            return new TypeBienDTO(typeBien.getId(), typeBien.getLibelle());
        }
        return null;
    }

    @Override
    public List<TypeBienDTO> findAll(){
        return typeBienRepository.findAll()
            .stream()
            .map(tb-> new TypeBienDTO(tb.getId(), tb.getLibelle()))
            .toList();
    }
}

