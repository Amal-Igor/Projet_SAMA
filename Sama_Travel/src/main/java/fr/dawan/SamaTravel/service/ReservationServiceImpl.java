package fr.dawan.SamaTravel.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.SamaTravel.entities.AppUserRole;
import fr.dawan.SamaTravel.entities.Reservation;
import fr.dawan.SamaTravel.repositories.ReservationRepository;


@Service
@Transactional
public class ReservationServiceImpl implements IReservationService {

	
	@Autowired
	ReservationRepository reservationRepo;
	
	
	

	@Override
	public void addReservation(Reservation resa) {
		reservationRepo.save(resa);
	}

}
