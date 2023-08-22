package fr.fixgia.roulemapoule.reservation;

import fr.fixgia.roulemapoule.trajet.Trajet;
import fr.fixgia.roulemapoule.user.UserEntity;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     UUID id;

    @Column
    UUID trajetID;

    @Column
    String dateReservation;

    @Column
    Integer nbDePlace;

    @Column
    UUID utilisateurID;




}
