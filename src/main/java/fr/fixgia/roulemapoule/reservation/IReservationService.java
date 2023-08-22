package fr.fixgia.roulemapoule.reservation;

import fr.fixgia.roulemapoule.trajet.Trajet;

import java.util.List;
import java.util.UUID;

public interface IReservationService {

    List<Reservation> getAllReservation();


    void reserver(Reservation reservation);

    void supprimerReservation(UUID uuid);

}

