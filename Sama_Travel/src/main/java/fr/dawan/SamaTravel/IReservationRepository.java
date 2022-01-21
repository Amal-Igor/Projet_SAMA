package fr.dawan.SamaTravel.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dawan.SamaTravel.entities.Reservation;

public interface IReservationRepository extends JpaRepository<Reservation, Integer> {

}
