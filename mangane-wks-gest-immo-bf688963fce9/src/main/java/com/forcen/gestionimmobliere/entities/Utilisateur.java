package com.forcen.gestionimmobliere.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Entity
@Builder
@Data
@AllArgsConstructor @NoArgsConstructor
public class Utilisateur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String prenom;
    private String nom;
    private  String adresse;
    private  int telephone;

    @OneToMany(mappedBy = "utilisateur" , fetch = FetchType.LAZY)
    List<Commande> commandes;

    @OneToOne
    @JoinColumn(name = "utilisateur")
    private Utilisateur utilisateur;

    @OneToMany(mappedBy = "utilisateur", fetch = FetchType.LAZY)
    List<Profil> profils;
}
