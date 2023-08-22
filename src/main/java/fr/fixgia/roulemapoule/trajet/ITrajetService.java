package fr.fixgia.roulemapoule.trajet;

import java.util.List;
import java.util.UUID;

public interface ITrajetService {

    void createTrajet(Trajet trajet);

    void saveTrajet(Trajet trajet);

    Trajet getTrajetById(UUID id);

    List<Trajet> getAllTrajet();

    void supprimerTrajet(UUID uuid);

    List<Trajet> getTrajetByVilleArrivee(String villeArrivee);

    List<Trajet> getTrajetByVilleDepart(String villeDepart);

    List<Trajet> getTrajetByVilleDepartAndArrivee(String villeDepart, String villeArrivee);

}
