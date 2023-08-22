package fr.fixgia.roulemapoule.trajet;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TrajetService implements ITrajetService{
    private final TrajetRepository trajetRepository;

    public TrajetService(TrajetRepository trajetRepository) {
        this.trajetRepository = trajetRepository;
    }

    @Override
    public void createTrajet(Trajet trajet) {
        trajet.setPlaces(trajet.getPlaces()- 1);
        trajetRepository.save(trajet);

    }

    public void saveTrajet(Trajet trajet) {
        trajetRepository.save(trajet);
    }



    @Override
    public List<Trajet> getAllTrajet() {
        return trajetRepository.findAll();
    }

    public List<Trajet> getTrajetByVilleDepart(String villeDepart) {
        return trajetRepository.findTrajetsByVilleDepart(villeDepart);
    }

    public List<Trajet> getTrajetByVilleArrivee(String villeArrivee) {
       return trajetRepository.findTrajetsByVilleArrivee(villeArrivee);
    }

    public List<Trajet> getTrajetByVilleDepartAndArrivee(String villeDepart, String villeArrivee) {
        return trajetRepository.findTrajetsByVilleDepartAndVilleArrivee(villeDepart,villeArrivee);
    }

    public Trajet getTrajetById(UUID id) {
        Optional<Trajet> trajet = trajetRepository.findById(id);
        if(trajet.isPresent()) {
            return trajet.get();
        }
        throw new RuntimeException("Le trajet n'existe pas");
    }

    @Override
    public void supprimerTrajet(UUID uuid) {
       Trajet trajetToDelete = trajetRepository.getReferenceById(uuid);
       trajetRepository.delete(trajetToDelete);
    }
}
