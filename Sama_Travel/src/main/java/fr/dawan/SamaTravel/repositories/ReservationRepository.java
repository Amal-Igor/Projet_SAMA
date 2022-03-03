package fr.dawan.SamaTravel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dawan.SamaTravel.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
