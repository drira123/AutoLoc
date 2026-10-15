package tn.esprit.aichadrira4cce11.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
//@FieldDefaults(level = AccessLevel.PRIVATE) fi 3oudh nekteb private kbal kol attribut nekteb hedhi w maghir private kbal kol attributs
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMaintenance;

    private LocalDate dateDebut;

    private LocalDate dateFin;

    private String description;

    // Plusieurs maintenances peuvent concerner un véhicule
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vehicule")
    @ToString.Exclude
    private Vehicule vehicule;
}