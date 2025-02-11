package com.forcen.gestionimmobliere.entities;


import com.forcen.gestionimmobliere.enums.TypeBienLabel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TypeBien implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private TypeBienLabel typeBienLabel;

    @OneToMany(mappedBy = "typeBienId", fetch = FetchType.LAZY)
    private List<Bien> biens;
}
