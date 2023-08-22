package fr.fixgia.roulemapoule.trajet;

import fr.fixgia.roulemapoule.user.UserEntity;
import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Entity
@Data
public class Trajet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    @Column
    String villeDepart;
    @Column
    String villeArrivee;
    @Column
    String date;
    @Column
    String description;
    @Column
    Integer Places;
    @Column
    Boolean complet;

    @Column
    UUID conducteurID;

    @Column
    Integer prix;

    @Column
    String heureDepart;

}
