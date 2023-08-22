package fr.fixgia.roulemapoule.reservation;

import fr.fixgia.roulemapoule.trajet.Trajet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/api/reservation")
@Slf4j
public class ReservationController {

   private final IReservationService reservationService;

    public ReservationController(IReservationService reservationService) {
        this.reservationService = reservationService;
    }


    @PostMapping("/addReservation")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation reserverTrajet(@RequestBody final Reservation reservation) {
        log.debug("Controller ReservationApplication: create Reservation - Called");
        reservationService.reserver(reservation);
        return reservation;
    }


    @DeleteMapping("/deleteReservation/{id}")
    public void deleteReservation(@PathVariable("id") UUID uuid){
        log.debug("Controller ReservationApplication: deleteReservation - called");
        reservationService.supprimerReservation(uuid);
    }

    @GetMapping("/all")
    public List<Reservation> getAllTrajet() {
        return reservationService.getAllReservation();
    }
}
