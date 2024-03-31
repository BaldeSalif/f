package com.forcen.gestionimmobliere.entities;

import com.forcen.gestionimmobliere.enums.Status;
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
    @JoinColumn(name = "categorie_id" , nullable = true, referencedColumnName = "id")
    private  Categorie categorieId;

    @ManyToOne
    @JoinColumn(name = "typeBien_id" , nullable = true, referencedColumnName = "id")
    private  TypeBien typeBienId;

    @OneToMany(mappedBy = "bienId", cascade = CascadeType.ALL)
    private List<Image> imagesBien;
}
