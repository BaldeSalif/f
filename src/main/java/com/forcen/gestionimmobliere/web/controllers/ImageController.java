package com.forcen.gestionimmobliere.web.controllers;

import com.forcen.gestionimmobliere.entities.Image;
import com.forcen.gestionimmobliere.services.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/images")
public class ImageController {

    private final ImageService imageService;

    @PostMapping("/create")
    public ResponseEntity<Image> saveImage(@RequestParam String name, @RequestPart("file") MultipartFile file ) throws IOException {
        Image savedImage = imageService.saveImage(name, file);
        return ResponseEntity.ok(savedImage);
    }

    @GetMapping
    public ResponseEntity<List<Image>> getAllImages(){
        List<Image> images = imageService.getAllImages();
        return ResponseEntity.ok(images);
    }




}
