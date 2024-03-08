package com.forcen.gestionimmobliere.entities;

import com.forcen.gestionimmobliere.enums.Etat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Commande  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateComm;
    private Etat etat;

    @ManyToOne
    @JoinColumn(name = "idUtilisateur" , nullable = true, referencedColumnName = "id")
    private  Utilisateur utilisateur;


}
