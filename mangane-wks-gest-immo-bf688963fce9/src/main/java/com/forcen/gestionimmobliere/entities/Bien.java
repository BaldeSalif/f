package com.forcen.gestionimmobliere.entities;

import com.forcen.gestionimmobliere.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bien  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String address;

    private String description;

    private double prix;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "idcategorie" , nullable = true,referencedColumnName = "id")
    private  Categorie categorie;

    @ManyToOne
    @JoinColumn(name = "idTypeBien" , nullable = true,referencedColumnName = "id")
    private  Type_Bien typeBien;

}
