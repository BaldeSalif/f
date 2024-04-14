package com.forcen.gestionimmobliere.services.impl;

import java.util.List;
import java.util.Optional;

import com.forcen.gestionimmobliere.entities.Image;
import com.forcen.gestionimmobliere.repository.ImageRepository;
import com.forcen.gestionimmobliere.web.dtos.ImageDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.forcen.gestionimmobliere.entities.Bien;
import com.forcen.gestionimmobliere.repository.BienRepository;
import com.forcen.gestionimmobliere.services.BienService;
import com.forcen.gestionimmobliere.web.dtos.BienDTO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BienServiceImpl implements BienService{
    
    BienRepository bienRepository;
    ImageRepository imageRepository;
    @Transactional
    @Override
    public BienDTO saveBien(BienDTO bienDTO) {
        Bien bien = new Bien();
        bien.setNom(bienDTO.nom());
        bien.setAddress(bienDTO.address());
        bien.setDescription(bienDTO.description());
        bien.setPrix(bienDTO.prix());
        Bien savedBien = bienRepository.save(bien);
        if (bienDTO.imagesBien() != null){
            bienDTO.imagesBien().stream().forEach(img -> {
                Image image = new Image();
                image.setName(img.name());
                image.setImageData(img.imageData());
                image.setBienId(savedBien);
                imageRepository.save(image);
            });
        }
        return bienMapper(savedBien);
    }

    @Override
    public BienDTO updateBien(BienDTO bienDTO){
      Bien bien = Bien.builder().id(bienDTO.id())
      .nom(bienDTO.nom())
      .address(bienDTO.address())
      .description(bienDTO.description())
      .prix(bienDTO.prix())
      .build();
      Bien updatedBien = bienRepository.save(bien);
      return bienMapper(updatedBien);
    }

    @Override
    public String deleteBien(Long id) {
        bienRepository.deleteById(id);
        return "Le bien a été supprimé";
    }

    @Override
    public BienDTO findById(Long id) {
        Optional<Bien> optionalBien = bienRepository.findById(id);
        if(optionalBien.isPresent()){
            Bien bien = optionalBien.get();
            return bienMapper(bien);
        }
        return null;
    }

    @Override
    public List<BienDTO> findAll(){
        List<Bien> biens = bienRepository.findAll();
        return bienListMapper(biens);
    }

    public List<BienDTO> bienListMapper(List<Bien> biens){
        return biens.stream()
                .map(bien -> new BienDTO(
                        bien.getId(),
                        bien.getNom(),
                        bien.getAddress(),
                        bien.getDescription(),
                        bien.getPrix(),
                        bien.getImagesBien().stream()
                                .map(image -> new ImageDTO(image.getId(), image.getName(), image.getImageData()))
                                .toList()))
                .toList();
    }

    public BienDTO bienMapper(Bien bien){
        return new BienDTO(
                bien.getId(),
                bien.getNom(),
                bien.getAddress(),
                bien.getDescription(),
                bien.getPrix(),
                bien.getImagesBien() != null ? bien.getImagesBien().stream()
                        .map(image -> new ImageDTO(image.getId(), image.getName(), image.getImageData()))
                        .toList() : null
        );
    }

}
       
