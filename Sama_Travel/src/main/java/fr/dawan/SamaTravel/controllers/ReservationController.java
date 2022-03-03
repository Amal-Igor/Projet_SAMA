package fr.dawan.SamaTravel.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.SamaTravel.entities.Reservation;
import fr.dawan.SamaTravel.repositories.ReservationRepository;

@RestController
public class ReservationController {
    
    @Autowired
    private ReservationRepository reservationRepository;
    
    
    @GetMapping("/reservations/{id}")
    public Optional<Reservation> getReservationById(@PathVariable Long id) {
        
        // Get reservation from the Database
        return reservationRepository.findById(id);
    }
    
    @GetMapping("/reservations")
    public List<Reservation> getReservationList() {
        
        // Get reservation from the Database
        return reservationRepository.findAll();
    }
    
    @PostMapping("/reservations/save")
    public Reservation postReservation(@RequestBody Reservation reservation) {
        
        // create reservation in Database
        return reservationRepository.save(reservation);
    }
    
    @PutMapping("/reservations/update/{id}")
    public void updateReservationById(@RequestBody Reservation reservation, @PathVariable Long id) {
        
        // modify reservation data in database
        reservation.setId(id);
        
        reservationRepository.save(reservation);
       
    }
    
    @DeleteMapping("/reservations/delete/{id}")
    public void deleteReservation(@PathVariable Long id) {
        
        // delete reserfvation from database
        reservationRepository.deleteById(id);
    }

}
