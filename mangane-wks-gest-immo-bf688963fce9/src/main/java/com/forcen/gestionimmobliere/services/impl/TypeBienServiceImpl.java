package com.forcen.gestionimmobliere.services.impl;

import com.forcen.gestionimmobliere.entities.Type_Bien;
import com.forcen.gestionimmobliere.repository.TypeBienRepository;
import com.forcen.gestionimmobliere.services.TypeBienService;
import com.forcen.gestionimmobliere.web.dtos.TypeBienDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class TypeBienServiceImpl implements TypeBienService {

    TypeBienRepository typeBienRepository;
    @Override
    public TypeBienDTO saveTypeBien(TypeBienDTO typeBienDTO) {
        Type_Bien typeBien = new Type_Bien();
        typeBien.setLibelle(typeBienDTO.libelle());
        Type_Bien savedTypeBien = typeBienRepository.save(typeBien);
        return new TypeBienDTO(savedTypeBien.getId(),savedTypeBien.getLibelle());
    }

    @SuppressWarnings("null")
    @Override
    public TypeBienDTO updateTypeBien(TypeBienDTO typeBienDTO) {
        Type_Bien typeBien = Type_Bien.builder().id(typeBienDTO.id())
            .libelle(typeBienDTO.libelle())
            .build();

        Type_Bien updatedTypeBien = typeBienRepository.save(typeBien);
        return  new TypeBienDTO(updatedTypeBien.getId(),updatedTypeBien.getLibelle());
    }

    @SuppressWarnings("null")
    @Override
    public void deleteTypeBien(TypeBienDTO typeBienDTO) {
         typeBienRepository.deleteById(typeBienDTO.id());
    }

    @SuppressWarnings("null")
    @Override
    public TypeBienDTO findById(Long id) {
        Optional<Type_Bien> optionalTypeBien = typeBienRepository.findById(id);
        if(optionalTypeBien.isPresent()){
            Type_Bien typeBien = optionalTypeBien.get();
            return new TypeBienDTO(typeBien.getId(), typeBien.getLibelle());
        }
        return null;
    }

    @Override
    public List<TypeBienDTO> findAll(){
        return typeBienRepository.findAll()
            .stream()
            .map(tb-> new TypeBienDTO(tb.getId(), tb.getLibelle()))
            .collect(Collectors.toList());
    }
}
