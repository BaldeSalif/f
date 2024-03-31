package com.forcen.gestionimmobliere.services;

import com.forcen.gestionimmobliere.entities.Image;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public interface ImageService {
    List<Image> getAllImages();

    Optional<Image> getImageById(Long id);

    Image saveImage(String name, MultipartFile file) throws IOException;

    Image updateImage(Image image);

    String deleteImage(Long id);
}
