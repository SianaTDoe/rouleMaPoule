package fr.fixgia.roulemapoule.trajet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TrajetRepository extends JpaRepository<Trajet, UUID> {

    List<Trajet> findTrajetsByVilleDepart(String villeDepart);

    List<Trajet> findTrajetsByVilleArrivee(String ville_arrivee);

    List<Trajet> findTrajetsByVilleDepartAndVilleArrivee(String villeDepart, String villeArrivee);
}
