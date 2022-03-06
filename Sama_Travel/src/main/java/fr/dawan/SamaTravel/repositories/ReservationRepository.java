package fr.dawan.SamaTravel.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dawan.SamaTravel.entities.Reservation;


public interface ReservationRepository extends JpaRepository<Reservation, Long>{

	
	Optional<Reservation> findById(Long id);

}