package com.forcen.gestionimmobliere.entities;

import com.forcen.gestionimmobliere.entities.enums.Status;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Bien {

    @Id
    private Long id;

    private String nom;

    private String address;

    private String description;

    private double prix;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "idBien" , nullable = true, referencedColumnName = "id")
    private  Categorie categorie;

}
