package com.forcen.gestionimmobliere.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Categorie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "categorieId")
    private List<Bien> bien;

}

