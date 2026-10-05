package tn.esprit.aichadrira4cce11.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
public class Agence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgence;

    private String nom;

    private String ville;

    private String adresse;

    private String telephone;

    @OneToMany(mappedBy = "agence")
    @ToString.Exclude
    private List<Employe> employes;

    @OneToMany(mappedBy = "agence")
    @ToString.Exclude
    private List<Vehicule> vehicules;
}