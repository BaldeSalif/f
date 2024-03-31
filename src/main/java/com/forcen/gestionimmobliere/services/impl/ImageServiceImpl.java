package com.forcen.gestionimmobliere.services.impl;

import com.forcen.gestionimmobliere.entities.Image;
import com.forcen.gestionimmobliere.repository.ImageRepository;
import com.forcen.gestionimmobliere.services.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;
    @Override
    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    @Override
    public Optional<Image> getImageById(Long id) {
        return imageRepository.findById(id);
    }

    @Override
    public Image saveImage(String name, MultipartFile file) throws IOException {
        Image imageToSave = Image.builder()
                .name(name)
                .imageData(file.getBytes())
                .build();
        return imageRepository.save(imageToSave);
    }

    @Override
    public Image updateImage(Image image) {
        Image imageToUpdate = Image.builder()
                .id(image.getId())
                .name(image.getName())
                .imageData(image.getImageData())
                .build();
        return imageRepository.save(imageToUpdate);
    }

    @Override
    public String deleteImage(Long id) {
        return null;
    }
}
