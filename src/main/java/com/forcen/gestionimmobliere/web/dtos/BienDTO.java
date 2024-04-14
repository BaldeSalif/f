package com.forcen.gestionimmobliere.web.dtos;

import java.util.List;

public record BienDTO(Long id, String nom, String address, String description, double prix, List<ImageDTO> imagesBien) { }
